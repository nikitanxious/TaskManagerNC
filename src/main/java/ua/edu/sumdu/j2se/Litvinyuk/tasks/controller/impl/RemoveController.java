package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;


import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl.RemoveView;

import java.io.FileNotFoundException;
import java.util.Scanner;


import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.EditController.selectTask;
import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.MainControllerImpl.list;
import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.ShowController.showTask;


public class RemoveController implements Controller {
    Scanner scanner = new Scanner(System.in);
    View view = new RemoveView();
    MainControllerImpl  mainController = new MainControllerImpl();
    Logger log = Logger.getLogger(RemoveController.class);

    public void remove()  {
        log.info("Removing task");
        showTask();
        System.out.println("Press the number task that you want to delete");
        int choice = scanner.nextInt();
        Task task = selectTask(choice);
        list.remove(task);
        mainController.continueProgram();
    }

    @Override
    public void execute() throws FileNotFoundException {
        showTask();
        view.printInfo();
        int numberOfTask = scanner.nextInt();
        Task task = selectTask(numberOfTask);
        list.remove(task);
        mainController.continueProgram();
    }

}
