package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;


import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl.MainView;


import java.time.LocalDateTime;

import java.util.Scanner;


import static ua.edu.sumdu.j2se.litvinyuk.tasks.model.TaskIO.writeText;

public class AddController {
    Logger log = Logger.getLogger(AddController.class);

    MainView mainView = new MainView();


    public void addTask(int number) {
        Scanner scanner = new Scanner(System.in);

        MainControllerImpl mainController = new MainControllerImpl();
        log.info("Create Task");
        if (number == 0) {
            System.out.println("write name");
            String name = scanner.nextLine();
            LocalDateTime time = createLocalDate();
            Task task1 = addNonRepeated(name, time);
            writeText(MainControllerImpl.list, MainControllerImpl.file);
            mainController.continueProgram();

        } else {
            if (number == 1) {
                System.out.println("write name");
                String name = scanner.nextLine();
                System.out.println("Write when you want  start doing task");
                LocalDateTime start = createLocalDate();
                System.out.println("Write when you want  end doing task");
                LocalDateTime end = createLocalDate();
                System.out.println("Write interval time");
                int repeatInterval = scanner.nextInt();
                System.out.println();
                Task task2 = addRepeated(name, start, end, repeatInterval);
                writeText(MainControllerImpl.list, MainControllerImpl.file);
                mainController.continueProgram();
            }
        }
    }

    public static LocalDateTime createLocalDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write year");
        int year = scanner.nextInt();
        System.out.println("write month");
        int month = scanner.nextInt();
        System.out.println("write day");
        int day = scanner.nextInt();
        System.out.println("write hour");
        int min = scanner.nextInt();
        System.out.println("write minutes");
        int sec = scanner.nextInt();
        return LocalDateTime.of(year, month, day, min, sec);

    }

    public Task addNonRepeated(String name, LocalDateTime date) {
        log.info("Add NonRepeated task");
        MainControllerImpl mainController = new MainControllerImpl();
        Task t = new Task(name, date);
        MainControllerImpl.list.add(t);
        System.out.println("Task add successful");
        mainController.continueProgram();
        return t;
    }

    public Task addRepeated(String title, LocalDateTime start, LocalDateTime end, int interval) {
        log.info("Add Repeated Task");
        MainControllerImpl mainController = new MainControllerImpl();
        Task t = new Task(title, start, end, interval);
        MainControllerImpl.list.add(t);
        System.out.println("Task add successful");
        mainController.continueProgram();
        return t;
    }





}
