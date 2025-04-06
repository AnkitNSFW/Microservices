package com.Microservice.FlightService.Repository;

import com.Microservice.FlightService.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    // Find flights by source and destination
    List<Flight> findBySourceAndDestination(String source, String destination);

    // Find flights by airline, source, destination
    List<Flight> findByAirline(String airline);
    List<Flight> findBySource(String source);
    List<Flight> findByDestination(String destination);

    // Find flight by flight number
    Optional<Flight> findByFlightNumber(String flightNumber);

    // Check is the Flight with a participle FlightNumber exist or not
    boolean existsByFlightNumber(String flightNumber);
}
