package ua.edu.sumdu.j2se.litvinyuk.tasks;


import org.apache.log4j.Logger;

import java.util.Scanner;

public class View {
    private Logger log = Logger.getLogger(View.class);
    private ViewTasks taskView;
    private Scanner scanner;

    public void showMenu() {
        log.info("Displaying the main user menu");
        System.out.println("Task Manager");
        System.out.println("# 1) Add task");
        System.out.println("# 2) Edit task");
        System.out.println("# 3) Delete task");
        System.out.println("# 4) Show tasks list");
        System.out.println("# 5) Show tasks calendar");
        System.out.println("# 0) Exit program");
        System.out.println("///////////////////////////");
        System.out.println("@ Your choice: ");
    }

    public void editMenu() {
        log.info("Displaying the user editing menu");
        System.out.println("Edit Menu");
        System.out.println("# 1) Task title");
        System.out.println("# 2) Task repeated status");
        System.out.println("# 3) Task active");
        System.out.println("# 4) Task time");
        System.out.println("# 0) To main menu");
        System.out.println("////////////////////////////");
        System.out.println("@ Your choice: ");
    }

    public void showTaskList(AbstractTaskList list) {
        log.info("Showing tasks' list");
        taskView.showList(list);
    }
    public boolean checkUserChoice() {
        log.info("Checking user answer");
        return userAnswer().equalsIgnoreCase("yes");
    }

    private String userAnswer() {
        log.info("Parsing the user response");
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("yes")
                && !answer.equalsIgnoreCase("no")) {
            System.out.println("You should select #Yes# or #No#: ");
            answer = scanner.nextLine();
        }
        return answer;
    }
}
