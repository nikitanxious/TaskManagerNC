package ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl;


import org.apache.log4j.Logger;

import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.EditController;
import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.MainControllerImpl;
import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.ShowController;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;

import java.util.Scanner;

public class EditView implements View {
    static Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(EditView.class);
    EditController editCont = new EditController();
    ShowController showCont = new ShowController();
    MainView mainView = new MainView();
    MainControllerImpl mainController;

    public EditView() {

    }


    public void printInfo() {
        logger.info("Displaying the user editing menu");
        System.out.println("==============Edit Menu==============");
        System.out.println("# 1) Task title");
        System.out.println("# 2) Task active");
        System.out.println("# 3) Task time");
        System.out.println("# 0) To main menu");
        System.out.println("========================================");
        System.out.println("@ Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ShowController.showTask();
                System.out.println("Select number of task that you want to edit");
                int unswer = scanner.nextInt();
                Task task = EditController.selectTask(unswer);
                editCont.editTaskTitle(task);
                mainController.continueProgram();
                break;
            case 2:
                ShowController.showTask();
                int unswer2 = scanner.nextInt();
                Task task1 = EditController.selectTask(unswer2);
                editCont.editActiveStatus(task1);
                mainController.continueProgram();
                break;
            case 3:
                ShowController.showTask();
                int unswer3 = scanner.nextInt();
                Task task2 = EditController.selectTask(unswer3);
                editCont.editTimeTask(task2);
                mainController.continueProgram();
                break;
        }
    }



}
