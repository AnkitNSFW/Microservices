package com.Microservice.FlightService.Service;

import com.Microservice.FlightService.DTO.FlightCreationDTO;
import com.Microservice.FlightService.DTO.FlightDTO;
import com.Microservice.FlightService.Exception.DuplicateFlightNumberException;
import com.Microservice.FlightService.Mapper.FlightMapper;
import com.Microservice.FlightService.Model.Flight;
import com.Microservice.FlightService.Repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;

    public List<FlightDTO> getAllFlights(){
        return flightRepo.findAll().stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FlightDTO getFlightById(Long id){
        return flightRepo.findById(id)
                .map(FlightMapper::toDTO)
                .orElse(null);
    }

    public FlightDTO getFlightByFlightNumber(String flightNumber){
        return flightRepo.findByFlightNumber(flightNumber)
                .map(FlightMapper::toDTO)
                .orElse(null);
    }

    public List<FlightDTO> getFlightByAirline(String airline){
        return flightRepo.findByAirline(airline).stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<FlightDTO> getFlightBySource(String source){
        return flightRepo.findBySource(source).stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<FlightDTO> getFlightByDestination(String destination){
        return flightRepo.findByDestination(destination).stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<FlightDTO> getFlightBySourceAndDestination(String source, String destination){
        return flightRepo.findBySourceAndDestination(source, destination).stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FlightDTO createFlight(FlightCreationDTO flightCreationDTO){
        if(flightRepo.existsByFlightNumber(flightCreationDTO.getFlightNumber())){
            throw new DuplicateFlightNumberException("Flight number already exists");
        }
        Flight newFlight = FlightMapper.toEntity(flightCreationDTO);
        return FlightMapper.toDTO(flightRepo.save(newFlight));
    }


}
