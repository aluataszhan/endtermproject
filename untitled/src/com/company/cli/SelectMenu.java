package com.company.cli;

import com.company.cli.select.*;
import com.company.entities.Plane;
import com.company.repository.*;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectMenu implements Menu {
    @Override
    public void menu() throws SQLException {
        System.out.println("Select option: ");
        System.out.println("1. Select planes");
        System.out.println("2. Select flights");
        System.out.println("3. Select passengers");
        System.out.println("4. Select places");
        System.out.println("5. Select tickets");
        System.out.println("0. Back to main menu");

        int option = Integer.parseInt((new Scanner(System.in)).nextLine());

        switch (option) {
            case 1:
                new SelectPlane().printResult(new PlaneRepo().getAllEntity());
                break;
            case 2:
                new SelectFlight().printResult(new FlightRepo().getAllEntity());
                break;
            case 3:
                new SelectPassenger().printResult(new PassengerRepo().getAllEntity());
                break;
            case 4:
                new SelectPlace().printResult(new PlaceRepo().getAllEntity());
                break;
            case 5:
                new SelectTickets().printResult(new TicketGenerator().getAllEntity());
                break;
            case 0:
                return;
            default:
                System.out.println("Something went wrong, please try again");
        }
        menu();
    }
}