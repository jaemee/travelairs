package com.example.travelairs.dto;

import com.example.travelairs.entity.Flights;

import static com.example.travelairs.util.FlightsUtil.convertDateToUTC;

public class FlightsResponse {

    private String flightNumber;
    private String departurePort;
    private String arrivalPort;
    private String departureTime;

    public static FlightsResponse convertTo(Flights flights) {
        FlightsResponse flightsResponse = new FlightsResponse();
        flightsResponse.setFlightNumber(flights.getFlightNumber());
        flightsResponse.setDeparturePort(flights.getDeparturePort());
        flightsResponse.setArrivalPort(flights.getArrivalPort());
        flightsResponse.setDepartureTime(convertDateToUTC(flights.getDepartureTime()));
        return flightsResponse;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
