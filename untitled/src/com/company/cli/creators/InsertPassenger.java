package com.company.cli.creators;

import com.company.entities.Entity;
import com.company.entities.Passenger;

import java.util.Scanner;

public class InsertPassenger implements Insert {
    @Override
    public Entity prepareData() {
        System.out.println("Insert passenger full name: ");
        String full_name = new Scanner(System.in).nextLine();
        return new Passenger(0, full_name);
    }
}
