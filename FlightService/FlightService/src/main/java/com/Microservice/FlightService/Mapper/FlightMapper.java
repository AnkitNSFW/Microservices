package com.Microservice.FlightService.Mapper;

import com.Microservice.FlightService.DTO.FlightCreationDTO;
import com.Microservice.FlightService.DTO.FlightDTO;
import com.Microservice.FlightService.DTO.FlightWithSchedulesDTO;
import com.Microservice.FlightService.Model.Flight;

import java.util.stream.Collectors;

public class FlightMapper {

    public static FlightDTO toDTO(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setId(flight.getId());
        dto.setAirline(flight.getAirline());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setSource(flight.getSource());
        dto.setDestination(flight.getDestination());
        dto.setDistance(flight.getDistance());
        dto.setDuration(flight.getDuration());
        return dto;
    }

    public static Flight toEntity(FlightCreationDTO dto) {
        Flight flight = new Flight();
        flight.setAirline(dto.getAirline());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        flight.setDistance(dto.getDistance());
        flight.setDuration(dto.getDuration());
        return flight;
    }

    public static FlightWithSchedulesDTO toFlightWithSchedulesDTO(Flight flight) {
        FlightWithSchedulesDTO dto = new FlightWithSchedulesDTO();
        dto.setId(flight.getId());
        dto.setAirline(flight.getAirline());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setSource(flight.getSource());
        dto.setDestination(flight.getDestination());
        dto.setDistance(flight.getDistance());
        dto.setDuration(flight.getDuration());

//        if (flight.getSchedules() != null) {
//            dto.setSchedules(flight.getSchedules().stream()
//                    .map(ScheduleMapper::toDTO)
//                    .collect(Collectors.toList()));
//        }

        return dto;
    }
}