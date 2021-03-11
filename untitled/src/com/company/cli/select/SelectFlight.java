package com.company.cli.select;

import com.company.entities.Entity;
import com.company.entities.Flight;

import java.util.Vector;

public class SelectFlight implements Select {
    @Override
    public void printResult(Vector<Entity> entities) {
        for (Entity i: entities) {
            Flight x = (Flight) i;
            System.out.println(
                    x.getFlight_id() + ". " +
                            x.getFrom_place() + " - " +
                            x.getTo_place() + ", " +
                            x.getFlight_time() + ", plane id: " +
                            x.getPlane_id()
            );
        }
    }
}
