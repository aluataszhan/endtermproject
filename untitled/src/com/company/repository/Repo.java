package com.company.repository;

import com.company.entities.Entity;
import com.company.entities.Flight;

import java.sql.SQLException;
import java.util.Vector;

public interface Repo {
    Entity getEntityWithId(int id) throws SQLException;
    Vector<Entity> getAllEntity() throws SQLException;
    void deleteEntity(int id) throws SQLException;
}
