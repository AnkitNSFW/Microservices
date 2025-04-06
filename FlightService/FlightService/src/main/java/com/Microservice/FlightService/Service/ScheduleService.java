package com.Microservice.FlightService.Service;

import com.Microservice.FlightService.DTO.FlightDTO;
import com.Microservice.FlightService.DTO.ScheduleDTO;
import com.Microservice.FlightService.Mapper.ScheduleMapper;
import com.Microservice.FlightService.Model.Schedule;
import com.Microservice.FlightService.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepo scheduleRepo;

    public List<ScheduleDTO> getAllSchedule(){
        return scheduleRepo.findAll().stream()
                .map(ScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }




    public List<ScheduleDTO> getSchedulesByFlightId(Long flightId) {
        return scheduleRepo.findByFlightId(flightId).stream()
                .map(ScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

}
