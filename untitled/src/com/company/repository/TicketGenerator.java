package com.company.repository;

import com.company.DatabaseConnection;
import com.company.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TicketGenerator {

    public Vector<Ticket> getAllEntity() throws SQLException {
        ResultSet rs = DatabaseConnection
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM flight NATURAL JOIN passenger NATURAL JOIN places NATURAL JOIN plane");
        Vector<Ticket> tickets = new Vector<>();
        while (rs.next()) {
            tickets.add(
                    new Ticket(
                            new Flight(
                                    rs.getInt("flight_id"),
                                    rs.getString("from_place"),
                                    rs.getString("to_place"),
                                    rs.getInt("plane_id"),
                                    rs.getString("flight_time"),
                                    rs.getInt("e_cost"),
                                    rs.getInt("b_cost"),
                                    rs.getInt("f_cost")
                            ),
                            new Passenger(
                                    rs.getInt("passenger_id"),
                                    rs.getString("passenger_full_name")
                            ),

                            new Plane(
                                    rs.getInt("plane_id"),
                                    rs.getString("plane_model")
                            ),
                            new Place(
                                    rs.getInt("place_id"),
                                    rs.getInt("flight_id"),
                                    rs.getInt("place_number"),
                                    rs.getInt("passenger_id"),
                                    rs.getString("place_type")
                            )
                    )
            );
        }
        return tickets;
    }
}
