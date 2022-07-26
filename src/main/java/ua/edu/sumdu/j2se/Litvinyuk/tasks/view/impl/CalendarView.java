package ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl;

import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.CalendarController;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;

import java.io.FileNotFoundException;

public class CalendarView implements View {
    CalendarController calendarController = new CalendarController();
    @Override
    public void printInfo()  {
        System.out.println("Specify a period of time");
        calendarController.execute();
    }
}
