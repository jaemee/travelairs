package com.example.travelairs.controller;

import com.example.travelairs.dto.FlightsResponse;
import com.example.travelairs.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightsService flightsService;

    @Autowired
    public FlightController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @PostMapping(value = "/getCurrentFlights")
    public ResponseEntity<List<FlightsResponse>> getCurrentFlights() {
        List<FlightsResponse> flightsList = flightsService.getCurrentFlights();
        return ResponseEntity.ok(flightsList);
    }
}
