package com.Microservice.FlightService.Controller;

import com.Microservice.FlightService.DTO.ScheduleDTO;
import com.Microservice.FlightService.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllSchedule(){
        List<ScheduleDTO> scheduleList = scheduleService.getAllSchedule();
        return new ResponseEntity<>(scheduleList ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ScheduleDTO>> getScheduleByFlightId(@PathVariable Long id){
        return new ResponseEntity<>(scheduleService.getSchedulesByFlightId(id) ,HttpStatus.OK);
    }

}
