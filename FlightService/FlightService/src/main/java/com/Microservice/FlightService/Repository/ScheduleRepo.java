package com.Microservice.FlightService.Repository;

import com.Microservice.FlightService.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByFlightId(Long flightId);
}
