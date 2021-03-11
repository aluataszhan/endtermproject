package com.company.entities;

public class Ticket {
    private Flight flight;
    private Passenger passenger;
    private Plane plane;
    private Place place;

    public Ticket(Flight flight, Passenger passenger, Plane plane, Place place) {
        this.flight = flight;
        this.passenger = passenger;
        this.plane = plane;
        this.place = place;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getInfo() {
        return "Flight id: " +
                flight.getFlight_id() + ". From: " +
                flight.getFrom_place() + ", to: " +
                flight.getTo_place() + ", time: " +
                flight.getFlight_time() + ", sit number: " +
                place.getPlace_number() + ", type " +
                place.getPlace_type() + ", plane model: " +
                plane.getPlane_model() + ", passenger: " +
                passenger.getPassenger_full_name();
    }
}
