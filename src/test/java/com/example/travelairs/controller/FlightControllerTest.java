package com.example.travelairs.controller;

import com.example.travelairs.dto.FlightsResponse;
import com.example.travelairs.service.FlightsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class FlightControllerTest {

    private MockMvc mockMvc;
    private FlightController flightController;

    @Mock
    private FlightsService flightsService;

    @Before
    public void setUp() {
        flightController = new FlightController(flightsService);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @Test
    public void shouldTestGetCurrentFlightsAPI() throws Exception {
        List<FlightsResponse> response = new ArrayList<>();
        when(flightsService.getCurrentFlights()).thenReturn(response);
        mockMvc.perform(get("/flights/getCurrentFlights")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(response)));
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}