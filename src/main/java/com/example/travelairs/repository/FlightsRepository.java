package com.example.travelairs.repository;

import com.example.travelairs.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

    @Query(value = "SELECT * FROM FLIGHTS WHERE TRUNC(DEPARTURETIME) = CURRENT_DATE", nativeQuery = true)
    List<Flights> getAllCurrentFlights();
}
