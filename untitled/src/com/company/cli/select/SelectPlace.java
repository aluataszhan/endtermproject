package com.company.cli.select;

import com.company.entities.Entity;
import com.company.entities.Passenger;
import com.company.entities.Place;

import java.util.Vector;

public class SelectPlace implements Select {
    @Override
    public void printResult(Vector<Entity> entities) {
        for (Entity i : entities) {
            Place x = (Place) i;
            System.out.println(
                    x.getPlace_id() + ". " +
                            x.getPlace_number() + " " +
                            x.getPassenger_id() + " " +
                            x.getPlace_type()
            );
        }
    }
}
