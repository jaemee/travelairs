package com.example.travelairs.service;

import com.example.travelairs.dto.FlightsResponse;
import com.example.travelairs.entity.Flights;
import com.example.travelairs.repository.FlightsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FlightsServiceTest {

    @Mock
    private FlightsRepository flightsRepository;

    private FlightsService flightsService;

    @Before
    public void setUp() {
        flightsService = new FlightsService(flightsRepository);
    }

    @Test
    public void shouldGetAllCurrentFlights() throws ParseException {
        List<Flights> flights = new ArrayList<>();
        Flights flight = new Flights();
        Date departureDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2021-07-08 08:00:00.000");
        String flightNumber = "QF400";
        String departurePort = "MEL";
        String arrivalPort = "SYD";
        String departureTimeUtc = "2021-07-08T00:00Z";

        flight.setFlightNumber(flightNumber);
        flight.setDeparturePort(departurePort);
        flight.setArrivalPort(arrivalPort);
        flight.setDepartureTime(departureDate);
        flights.add(flight);

        FlightsResponse flightsResponse = new FlightsResponse();
        flightsResponse.setFlightNumber(flightNumber);
        flightsResponse.setArrivalPort(arrivalPort);
        flightsResponse.setDeparturePort(departurePort);
        flightsResponse.setDepartureTime(departureTimeUtc);

        when(flightsRepository.getAllCurrentFlights()).thenReturn(flights);
        List<FlightsResponse> currentFlights = flightsService.getCurrentFlights();
        assertThat(currentFlights.get(0).getFlightNumber()).isEqualTo(flightNumber);
        assertThat(currentFlights.get(0).getArrivalPort()).isEqualTo(arrivalPort);
        assertThat(currentFlights.get(0).getDeparturePort()).isEqualTo(departurePort);
        assertThat(currentFlights.get(0).getDepartureTime()).isEqualTo(departureTimeUtc);
    }
}