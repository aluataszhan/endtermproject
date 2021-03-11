package com.company.repository;

import com.company.DatabaseConnection;
import com.company.entities.Entity;
import com.company.entities.Passenger;
import com.company.entities.Place;
import com.company.entities.Plane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PlaneRepo implements Repo {
    @Override
    public Entity getEntityWithId(int id) throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM plane WHERE passenger_id = " + id);
        if (rs.next()) {
            return new Plane(
                    rs.getInt("plane_id"),
                    rs.getString("plane_model")
            );
        } else return null;
    }

    @Override
    public Vector<Entity> getAllEntity() throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM plane");
        Vector<Entity> planes = new Vector<>();
        while (rs.next()) {
            planes.add(
                    new Plane(
                            rs.getInt("plane_id"),
                            rs.getString("plane_model")
                    )
            );
        }
        return planes;
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeUpdate("DELETE FROM plane WHERE plane_id = " + id);
    }
}
