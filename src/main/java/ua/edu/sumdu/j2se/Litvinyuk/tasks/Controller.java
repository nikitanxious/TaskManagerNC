package ua.edu.sumdu.j2se.litvinyuk.tasks;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Controller {
    private Logger log = Logger.getLogger(Controller.class);
    private Scanner scanner;
    private View view;

    public void execute() {
            log.info("Executing main controller command");
            while (true) {
                view.showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    System.out.println("Do you want to finish? (Yes:No): ");
                    if (view.checkUserChoice()) {
                        System.out.println("Program was finished");
                        log.info("The Task Manager application is getting ready to end");
                        break;
                    }
                } else {
                    switch (choice) {
                        case 1:
                           // addTask
                            break;
                        case 2:
                            // Edit Task
                            break;
                        case 3:
                           // remove
                            break;
                        case 4:
                            // show task
                            break;
                        case 5:
                            // calendar
                            break;
                    }
                }
            }
        }
    }

