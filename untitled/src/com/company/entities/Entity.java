package com.company.entities;

import com.company.DatabaseConnection;

import java.sql.SQLException;

public abstract class Entity {
    public abstract String getInsertQuery();

    public void insert() throws SQLException {
        DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement()
                .execute(this.getInsertQuery());
    }
}
