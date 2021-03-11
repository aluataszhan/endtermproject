package com.company.entities;

public class Plane extends Entity {
    private int id = 0;
    private String plane_model;

    public Plane(String plane_model) {
        this.plane_model = plane_model;
    }

    public Plane(int id, String plane_model) {
        this.id = id;
        this.plane_model = plane_model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlane_model() {
        return plane_model;
    }

    public void setPlane_model(String plane_model) {
        this.plane_model = plane_model;
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO plane (plane_model) VALUES ('"+this.plane_model+"')";
    }
}
