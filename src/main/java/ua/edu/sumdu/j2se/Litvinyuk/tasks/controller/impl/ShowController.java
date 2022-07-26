package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.MainControllerImpl.file;
import static ua.edu.sumdu.j2se.litvinyuk.tasks.model.TaskIO.read;
import static ua.edu.sumdu.j2se.litvinyuk.tasks.model.TaskIO.readText;

public class ShowController {
    static Logger log = Logger.getLogger(ShowController.class);

    public static void showTask() {
        log.info("Show tasks");
        int count = 1;
        for (Task task : MainControllerImpl.list) {
            System.out.println("Number task is" + " #" + count + " " + task.getTitle() + " " + task.getTime());
            count++;
        }
        // ArrayList<String> arrayList = new ArrayList<>();
        //try (BufferedReader reader = new BufferedReader(new FileReader(MainControllerImpl.file))) {
        //  while (reader.ready()) {
        //    arrayList.add(reader.readLine());
        //}
        //} catch (IOException e) {
        //e.getStackTrace();
        // }
    }


}
