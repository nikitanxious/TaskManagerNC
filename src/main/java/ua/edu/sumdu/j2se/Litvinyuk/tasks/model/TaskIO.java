package ua.edu.sumdu.j2se.litvinyuk.tasks.model;

import com.google.gson.Gson;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class TaskIO {

    private static ZoneId zoneId = ZoneId.systemDefault();


    public static void write(AbstractTaskList tasks, OutputStream out) {

        try (DataOutputStream outStream = new DataOutputStream(out)){
            outStream.writeInt(tasks.size());
            for (Task task : tasks) {
                outStream.writeInt(task.getTitle().length());
                outStream.writeUTF(task.getTitle());
                outStream.writeBoolean(task.isActive());
                outStream.writeInt(task.getRepeatInterval());
                outStream.writeLong(task.getStartTime().atZone(zoneId).toInstant().toEpochMilli());
                if (task.isRepeated()) {
                    outStream.writeLong(task.getEndTime().atZone(zoneId).toInstant().toEpochMilli());
                }
            }
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void read(AbstractTaskList tasks, InputStream in)  {
        try (DataInputStream inputStream = new DataInputStream(in)) {
            int countTask = inputStream.readInt();
            for (int i = 0; i < countTask; i++) {

                int lengthTitle = inputStream.readInt();
                String title = inputStream.readUTF();

                boolean active = inputStream.readBoolean();
                int interval = inputStream.readInt();

                LocalDateTime start = Instant.ofEpochMilli(inputStream.readLong()).atZone(zoneId).toLocalDateTime();

                Task inTask;
                if (interval == 0) {
                    inTask = new Task(title, start);
                } else {
                    LocalDateTime end = Instant.ofEpochMilli(inputStream.readLong()).atZone(zoneId).toLocalDateTime();
                    inTask = new Task(title, start, end, interval);
                }
                inTask.setActive(active);
                tasks.add(inTask);
            }
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void writeBinary(AbstractTaskList tasks, File file) {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            write(tasks, outStream);
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void readBinary(AbstractTaskList tasks, File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            read(tasks, inputStream);
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void write(AbstractTaskList tasks, Writer out) {
        try (BufferedWriter writer = new BufferedWriter(out)) {
            Gson gson = new Gson();
            String line = gson.toJson(tasks);
            writer.write(line);
            writer.flush();
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void read(AbstractTaskList tasks, Reader in)  {
        try (BufferedReader reader = new BufferedReader(in)) {
            String readText = reader.readLine();
            AbstractTaskList taskList = new Gson().fromJson(readText, tasks.getClass());
            for (Task task : taskList) {
                tasks.add(task);
            }
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void writeText(AbstractTaskList tasks, File file)  {
        try (FileWriter fileWriter = new FileWriter(file)) {
            write(tasks, fileWriter);
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void readText(AbstractTaskList tasks, File file) {
        try (FileReader fileReader = new FileReader(file)) {
            read(tasks, fileReader);
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
