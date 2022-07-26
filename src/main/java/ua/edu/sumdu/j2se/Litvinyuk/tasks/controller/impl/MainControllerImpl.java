package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;


import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.Notification.checkTimeTask;


public class MainControllerImpl implements Controller {
    public static File file = new File("C:\\Users\\katam\\IdeaProjects\\NCTaskManager\\src\\main\\java\\ua\\edu\\sumdu\\j2se\\litvinyuk\\tasks\\tasklist");
    public static ArrayTaskList list = new ArrayTaskList();
    static Scanner scanner = new Scanner(System.in);
    MainView mainView = new MainView();
    AddView addView = new AddView();
    RemoveController removeController;
    Logger log = Logger.getLogger(MainControllerImpl.class);


    public void CheckUserAnswer(int choice)  {
        log.info("Check answer");
        EditView editView = new EditView();
        RemoveView removeView = new RemoveView();
        CalendarController controller = new CalendarController();
        CalendarView calendarView = new CalendarView();
        ShowView showView = new ShowView();
        if (choice == 1)
            addView.printInfo();
        if (choice == 2)
            editView.printInfo();
        if (choice == 3)
            removeView.printInfo();
        if (choice == 4)
            showView.printInfo();
        if (choice == 5)
            calendarView.printInfo();
    }

    public AbstractTaskList getList(AbstractTaskList list) {
        return list;
    }

    public void continueProgram() {
        mainView.printInfo();
        int answer = scanner.nextInt();
        CheckUserAnswer(answer);
    }

    @Override
    public void execute() throws AWTException {
        log.info("Start program");
        mainView.printInfo();
        int i = scanner.nextInt();
        if (i == 0) {
            System.out.println("Program was finished");
        }
        CheckUserAnswer(i);
        checkTimeTask();
    }

}
