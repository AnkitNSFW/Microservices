package com.Microservice.FlightService.Mapper;

import com.Microservice.FlightService.DTO.ScheduleCreationDTO;
import com.Microservice.FlightService.DTO.ScheduleDTO;
import com.Microservice.FlightService.Model.Schedule;

public class ScheduleMapper {
    public static ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setFlightId(schedule.getFlight().getId());
        dto.setDepartureTime(schedule.getDepartureTime());
        dto.setArrivalTime(schedule.getArrivalTime());
        dto.setPrice(schedule.getPrice());
        dto.setSeatsAvailable(schedule.getSeatsAvailable());
        return dto;
    }

    public static Schedule toEntity(ScheduleCreationDTO dto) {
        Schedule schedule = new Schedule();
        // Note: Need to set Flight entity manually in the service layer using dto.getFlightId()
        schedule.setDepartureTime(dto.getDepartureTime());
        schedule.setArrivalTime(dto.getArrivalTime());
        schedule.setPrice(dto.getPrice());
        schedule.setSeatsAvailable(dto.getSeatsAvailable());
        return schedule;
    }
}
