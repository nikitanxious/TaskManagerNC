package ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl;

import ua.edu.sumdu.j2se.litvinyuk.tasks.controller.impl.AddController;
import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddView implements View {
    static Scanner scanner = new Scanner(System.in);
    AddController addController = new AddController();


    public String requestDataFromUser(String request) {
        return null;
    }


    public  void printInfo() {
        System.out.println("Which task do you want to add?");
        System.out.println("#0 NonRepeated");
        System.out.println("#1 Reapeted");
        int choice = scanner.nextInt();
        addController.addTask(choice);
    }


}
