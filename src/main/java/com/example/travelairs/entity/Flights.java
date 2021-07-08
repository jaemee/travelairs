package com.example.travelairs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "flights")
@Table(name = "FLIGHTS")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "flightnumber")
    private String flightNumber;

    @Column(name = "departureport")
    private String departurePort;

    @Column(name = "arrivalport")
    private String arrivalPort;

    @Column(name = "departuretime")
    private Date departureTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}