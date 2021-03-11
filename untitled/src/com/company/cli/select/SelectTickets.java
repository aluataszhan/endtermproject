package com.company.cli.select;

import com.company.entities.Entity;
import com.company.entities.Plane;
import com.company.entities.Ticket;

import java.util.Vector;

public class SelectTickets {
    public void printResult(Vector<Ticket> entities) {
        for (Ticket i : entities) {
            System.out.println(i.getInfo());
        }
    }
}
