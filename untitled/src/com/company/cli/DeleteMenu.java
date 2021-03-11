package com.company.cli;

import com.company.repository.FlightRepo;
import com.company.repository.PassengerRepo;
import com.company.repository.PlaceRepo;
import com.company.repository.PlaneRepo;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMenu implements Menu {
    public int prepareId() {
        System.out.println("Insert id: ");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    @Override
    public void menu() throws SQLException {
        System.out.println("Select option: ");
        System.out.println("1. Delete planes");
        System.out.println("2. Delete flights");
        System.out.println("3. Delete passengers");
        System.out.println("4. Delete places");
        System.out.println("0. Back to main menu");

        int option = Integer.parseInt((new Scanner(System.in)).nextLine());

        switch (option) {
            case 1:
                new PlaneRepo().deleteEntity(prepareId());
                break;
            case 2:
                new FlightRepo().deleteEntity(prepareId());
                break;
            case 3:
                new PassengerRepo().deleteEntity(prepareId());
                break;
            case 4:
                new PlaceRepo().deleteEntity(prepareId());
                break;
            case 0:
                return;
            default:
                System.out.println("Something went wrong, please try again");
        }
        menu();
    }
}
