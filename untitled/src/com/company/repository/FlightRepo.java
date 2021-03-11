package com.company.repository;

import com.company.DatabaseConnection;
import com.company.entities.Entity;
import com.company.entities.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class FlightRepo implements Repo {
    @Override
    public Entity getEntityWithId(int id) throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM flight WHERE flight_id = " + id);
        if (rs.next()) {
            return new Flight(
                    rs.getInt("flight_id"),
                    rs.getString("from_place"),
                    rs.getString("to_place"),
                    rs.getInt("plane_id"),
                    rs.getString("flight_time"),
                    rs.getInt("e_cost"),
                    rs.getInt("b_cost"),
                    rs.getInt("f_cost")
            );
        } else return null;
    }

    @Override
    public Vector<Entity> getAllEntity() throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM flight");
        Vector<Entity> flights = new Vector<>();
        while (rs.next()) {
            flights.add(
                    new Flight(
                            rs.getInt("flight_id"),
                            rs.getString("from_place"),
                            rs.getString("to_place"),
                            rs.getInt("plane_id"),
                            rs.getString("flight_time"),
                            rs.getInt("e_cost"),
                            rs.getInt("b_cost"),
                            rs.getInt("f_cost")
                    )
            );
        }
        return flights;
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeUpdate("DELETE FROM flight WHERE flight_id = " + id);
    }
}
