package ua.edu.sumdu.j2se.litvinyuk.tasks;

import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.MainControllerImpl;
import java.awt.*;
import java.io.FileNotFoundException;


class MainClass {
    public static void main(String[] args) throws FileNotFoundException, AWTException {

        MainControllerImpl mainController = new MainControllerImpl();
        mainController.execute();


    }
}