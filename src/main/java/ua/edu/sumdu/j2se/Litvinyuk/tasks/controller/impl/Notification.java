package ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl;

import ua.edu.sumdu.j2se.litvinyuk.tasks.model.Task;

import java.awt.*;
import java.time.LocalDateTime;

public class Notification {

    public void displayTray() throws AWTException {

        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("TIME TO DO TASK", "", TrayIcon.MessageType.INFO);
    }

    public static void checkTimeTask() throws AWTException {
        while (true) {
            Notification notification = new Notification();
            for (Task task : MainControllerImpl.list) {
                if (task.isRepeated()) {
                    if (task.getStartTime() == LocalDateTime.now())
                        notification.displayTray();
                } else {
                    if (task.getTime() == LocalDateTime.now())
                        notification.displayTray();
                }
            }
        }
    }
}
