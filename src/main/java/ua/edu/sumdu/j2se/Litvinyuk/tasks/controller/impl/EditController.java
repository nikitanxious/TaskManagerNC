package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl.MainView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EditController {
    AddController addController;
    MainView mainView = new MainView();
    MainControllerImpl mainController = new MainControllerImpl();
    Logger log = Logger.getLogger(EditController.class);

    public void editTaskTitle(Task task) {
        log.info("Editing title");
        System.out.println("Write the new name for this task");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        task.setTitle(title);
        mainController.continueProgram();
    }

    public void editActiveStatus(Task task) {
        log.info("Editing active status");
        if (task.isRepeated()) {
            task.setActive(false);
        } else {
            task.setActive(true);
        }
        mainController.continueProgram();
    }

    public void editTimeTask(Task task) {
        log.info("Editing time");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want change  time?" + "Select yes or no");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            if (task.isRepeated()) {
                System.out.println("Write start time");
                LocalDateTime startTime = AddController.createLocalDate();
                System.out.println("Write end time");
                LocalDateTime endTime = AddController.createLocalDate();
                System.out.println("Write interval time");
                int repeatedInterval = scanner.nextInt();
                task.setTime(startTime, endTime, repeatedInterval);
            } else {
                System.out.println("Write new time to task");
                LocalDateTime time = AddController.createLocalDate();
                task.setTime(time);
            }
        }
        if (choice.equalsIgnoreCase("no")) {

        }
        mainController.continueProgram();
    }

    public static Task selectTask(int userUnswer) {
        int counter = 1;
        Task select = null;
        for (Task task : MainControllerImpl.list) {
            if (counter == userUnswer) {
                select = task;
            }
            counter++;
        }
        return select;
    }
}
