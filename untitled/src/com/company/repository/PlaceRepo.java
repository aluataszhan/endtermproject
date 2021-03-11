package com.company.repository;

import com.company.DatabaseConnection;
import com.company.entities.Entity;
import com.company.entities.Passenger;
import com.company.entities.Place;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PlaceRepo implements Repo {
    @Override
    public Entity getEntityWithId(int id) throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM places WHERE passenger_id = " + id);
        if (rs.next()) {
            return new Place(
                    rs.getInt("place_id"),
                    rs.getInt("flight_id"),
                    rs.getInt("place_number"),
                    rs.getInt("passenger_id"),
                    rs.getString("place_type")
            );
        } else return null;
    }

    @Override
    public Vector<Entity> getAllEntity() throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM places");
        Vector<Entity> places = new Vector<>();
        while (rs.next()) {
            places.add(
                    new Place(
                            rs.getInt("place_id"),
                            rs.getInt("flight_id"),
                            rs.getInt("place_number"),
                            rs.getInt("passenger_id"),
                            rs.getString("place_type")
                    )
            );
        }
        return places;
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeUpdate("DELETE FROM places WHERE place_id = " + id);
    }
}
