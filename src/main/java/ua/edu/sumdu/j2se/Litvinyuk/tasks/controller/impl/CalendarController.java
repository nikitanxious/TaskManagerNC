package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;
import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;


import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.AddController.createLocalDate;
import static ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.MainControllerImpl.list;

public class CalendarController implements Controller {
    Logger log = Logger.getLogger(CalendarController.class);

    @Override
    public void execute()  {
        log.info("Making calendar");
        System.out.println("Select start time");
        LocalDateTime start = createLocalDate();
        System.out.println("Select end time");
        LocalDateTime end = createLocalDate();
        for (Task task : list) {
            if (task.isRepeated()) {
                if (task.getStartTime().isAfter(start) && task.getEndTime().isBefore(end))
                    System.out.println(task);
            } else {
                if (task.getTime().isBefore(end) && task.getTime().isAfter(start))
                    System.out.println(task);
            }
        }
    }
}
