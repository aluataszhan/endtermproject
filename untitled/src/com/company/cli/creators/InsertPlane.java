package com.company.cli.creators;

import com.company.entities.Entity;
import com.company.entities.Plane;

import java.util.Scanner;

public class InsertPlane implements Insert {
    @Override
    public Entity prepareData() {

        System.out.println("Insert plane model: ");
        String model = new Scanner(System.in).nextLine();
        return new Plane(model);
    }
}
