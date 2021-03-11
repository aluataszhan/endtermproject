package com.company.cli.creators;

import com.company.entities.Entity;
import com.company.entities.Flight;

import java.util.Scanner;

public class InsertFlight implements Insert {
    @Override
    public Entity prepareData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert flight place: ");
        String from_place = scan.nextLine();
        System.out.println("Insert point place: ");
        String to_place = scan.nextLine();
        System.out.println("Insert plane id: ");
        int plane_id = Integer.parseInt(scan.nextLine());
        System.out.println("Insert flight time (format: yyyy-MM-dd hh-mm-ss): ");
        String time = scan.nextLine();
        System.out.println("Cost for Economy class: ");
        int e_cost = Integer.parseInt(scan.nextLine());
        System.out.println("Cost for Business class: ");
        int b_cost = Integer.parseInt(scan.nextLine());
        System.out.println("Cost for First class: ");
        int f_cost = Integer.parseInt(scan.nextLine());

        return new Flight(0, from_place, to_place, plane_id, time, e_cost, b_cost, f_cost);
    }
}
