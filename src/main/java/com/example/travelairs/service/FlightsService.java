package com.example.travelairs.service;

import com.example.travelairs.dto.FlightsResponse;
import com.example.travelairs.entity.Flights;
import com.example.travelairs.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightsService {

    private final FlightsRepository flightsRepository;

    @Autowired
    public FlightsService(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public List<FlightsResponse> getCurrentFlights() {
        List<Flights> flightsList = flightsRepository.getAllCurrentFlights();
        return flightsList.stream()
                .map(FlightsResponse::convertTo)
                .collect(Collectors.toList());
    }
}
