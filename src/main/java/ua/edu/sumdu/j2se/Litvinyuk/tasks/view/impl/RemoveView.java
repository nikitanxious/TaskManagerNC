package ua.edu.sumdu.j2se.litvinyuk.tasks.view.impl;

import ua.edu.sumdu.j2se.litvinyuk.tasks.view.View;

import java.util.Scanner;

public class RemoveView implements View {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void printInfo() {
        System.out.println("Press the number task that you want to delete");
    }

}
