package com.company.cli.select;

import com.company.entities.Entity;
import com.company.entities.Passenger;

import java.util.Vector;

public class SelectPassenger implements Select {
    @Override
    public void printResult(Vector<Entity> entities) {
        for (Entity i: entities) {
            Passenger x = (Passenger) i;
            System.out.println(x.getId() + ". " + x.getPassenger_full_name());
        }
    }
}
