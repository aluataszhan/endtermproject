package com.company.repository;

import com.company.DatabaseConnection;
import com.company.entities.Entity;
import com.company.entities.Flight;
import com.company.entities.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PassengerRepo implements Repo {
    @Override
    public Entity getEntityWithId(int id) throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM passenger WHERE passenger_id = " + id);
        if (rs.next()) {
            return new Passenger(
                    rs.getInt("passenger_id"),
                    rs.getString("passenger_full_name")
            );
        } else return null;
    }

    @Override
    public Vector<Entity> getAllEntity() throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM passenger");
        Vector<Entity> passengers = new Vector<>();
        while (rs.next()) {
            passengers.add(
                    new Passenger(
                            rs.getInt("passenger_id"),
                            rs.getString("passenger_full_name")
                    )
            );
        }
        return passengers;
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeUpdate("DELETE FROM passenger WHERE passenger_id = " + id);
    }
}
