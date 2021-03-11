package com.company.cli.select;

import com.company.entities.Entity;
import com.company.entities.Plane;

import java.util.Vector;

public class SelectPlane implements Select {
    @Override
    public void printResult(Vector<Entity> entities) {
        for (Entity i : entities) {
            Plane x = (Plane) i;
            System.out.println(x.getId() + ". " + x.getPlane_model());
        }
    }
}
