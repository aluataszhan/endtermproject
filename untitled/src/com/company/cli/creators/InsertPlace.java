package com.company.cli.creators;

import com.company.entities.Entity;
import com.company.entities.Place;

import java.util.Scanner;

public class InsertPlace implements Insert {
    @Override
    public Entity prepareData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert flight id: ");
        int f_id = Integer.parseInt(scan.nextLine());
        System.out.println("Insert place number: ");
        int p_number = Integer.parseInt(scan.nextLine());
        System.out.println("Insert passenger id: ");
        int p_id = Integer.parseInt(scan.nextLine());
        System.out.println("Insert place type (e - economy, b - business, f - first)");
        String type = scan.nextLine();

        return new Place(0, f_id, p_number, p_id, type);
    }
}
