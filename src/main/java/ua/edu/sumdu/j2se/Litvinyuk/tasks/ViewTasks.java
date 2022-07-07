package ua.edu.sumdu.j2se.litvinyuk.tasks;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ViewTasks {
    private Logger log =  Logger.getLogger(ViewTasks.class);
    private Scanner scanner;
    private ViewTasks taskView;

    public void showList(AbstractTaskList list) {
        log.info("Showing all task list");
        if (list.size() == 0) {
            log.info("List is empty");
        } else {
            getList(list);
        }
    }

    private void getList(AbstractTaskList list) {
        log.info("Getting not empty task list");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        StringBuilder repeated = new StringBuilder();
        StringBuilder notRepeated = new StringBuilder();
        int i = 1;
        for (Task t : list) {
            String title = t.getTitle();
            String time = t.getTime().format(formatter);
            String start = t.getStartTime().format(formatter);
            String end = t.getEndTime().format(formatter);
            int interval = t.getRepeatInterval();
            String active = t.isActive() ? "active" : "inactive";

            if (t.isRepeated()) {
                log.info("Setting repeated task to general list");
                repeated.append(i++).append("\t")
                        .append(title).append("\t\t")
                        .append(start).append("\t")
                        .append(end).append("\t")
                        .append(interval).append("\t")
                        .append(active).append("\n");
            } else {
                log.info("Setting not repeated task to general list");
                notRepeated.append(i++).append("\t")
                        .append(title).append("\t\t")
                        .append(time).append("\t")
                        .append(active).append("\n");
            }
        }
        showRepeated(repeated);
        showNotRepeated(notRepeated);
    }

    private void showRepeated(StringBuilder repeated) {
        log.info("Printing repeated task list");
        System.out.println(repeated.toString());
    }

    private void showNotRepeated(StringBuilder notRepeated) {
        log.info("Printing not repeated task list");

        System.out.println(notRepeated.toString());
    }
    private String userAnswer() {
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("yes")
                && !answer.equalsIgnoreCase("no")) {
            System.out.println("You should select #Yes# or #No#: ");
            answer = scanner.nextLine();
        }
        return answer;
    }

}
