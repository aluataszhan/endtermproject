package com.company.cli;

import com.company.cli.select.SelectPlace;

import java.util.Scanner;

public class MainMenu implements Menu {
    @Override
    public void menu() {
        System.out.println("Select option: ");
        System.out.println("1. Get info");
        System.out.println("2. Insert info");
        System.out.println("3. Remove info");
        System.out.println("0. Quit");

        int option = Integer.parseInt((new Scanner(System.in)).nextLine());

        try {
            switch (option) {
                case 1:
                    new SelectMenu().menu();
                    break;
                case 2:
                    new InsertMenu().menu();
                    break;
                case 3:
                    new DeleteMenu().menu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Something went wrong, please try again");
            }

        }
        catch (Exception e) {
            System.out.println("Something went wrong. Exception: " + e.getMessage());
        }
        menu();
    }
}
