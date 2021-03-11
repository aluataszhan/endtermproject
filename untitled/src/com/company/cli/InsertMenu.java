package com.company.cli;

import com.company.cli.creators.InsertFlight;
import com.company.cli.creators.InsertPassenger;
import com.company.cli.creators.InsertPlace;
import com.company.cli.creators.InsertPlane;
import com.company.repository.PlaneRepo;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertMenu implements Menu {
    @Override
    public void menu() throws SQLException {
        System.out.println("Select option: ");
        System.out.println("1. Insert planes");
        System.out.println("2. Insert flights");
        System.out.println("3. Insert passengers");
        System.out.println("4. Insert places");
        System.out.println("0. Back to main menu");

        int option = Integer.parseInt((new Scanner(System.in)).nextLine());

        switch (option) {
            case 1:
                new InsertPlane().prepareData().insert();
                break;
            case 2:
                new InsertFlight().prepareData().insert();
                break;
            case 3:
                new InsertPassenger().prepareData().insert();
                break;
            case 4:
                new InsertPlace().prepareData().insert();
                break;
            case 0:
                return;
            default:
                System.out.println("Something went wrong, please try again");
        }
        menu();
    }
}
