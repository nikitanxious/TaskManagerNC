package ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;

import java.util.Scanner;

public class MainView implements View {
static Logger logger = Logger.getLogger(MainView.class);


    public String requestDataFromUser(String request) {
        Scanner scanner = new Scanner(System.in);
        String requestUser = scanner.nextLine();
        return requestUser;
    }




    public  void printInfo() {
        logger.info("Displaying the main user menu");
        System.out.println("==============Task Manager==============");
        System.out.println("# 1) Add task");
        System.out.println("# 2) Edit task");
        System.out.println("# 3) Delete task");
        System.out.println("# 4) Show tasklist");
        System.out.println("# 5) Show tasks calendar");
        System.out.println("# 0) Exit program");
        System.out.println("========================================");
        System.out.println("@ Your choice: ");

    }

}
