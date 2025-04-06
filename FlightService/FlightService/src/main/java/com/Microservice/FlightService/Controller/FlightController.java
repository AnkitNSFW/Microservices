package com.Microservice.FlightService.Controller;

import com.Microservice.FlightService.DTO.FlightCreationDTO;
import com.Microservice.FlightService.DTO.FlightDTO;
import com.Microservice.FlightService.Exception.DuplicateFlightNumberException;
import com.Microservice.FlightService.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.ResponseAPDU;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlight(){
        List<FlightDTO> fligthList = flightService.getAllFlights();
        if(fligthList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(fligthList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id){
        FlightDTO flightDTO = flightService.getFlightById(id);
        if(flightDTO ==null){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(flightDTO, HttpStatus.OK);
    }

    @GetMapping("/number/{flightNumber}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable String flightNumber){
        FlightDTO flightDTO = flightService.getFlightByFlightNumber(flightNumber);
        if(flightDTO ==null){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(flightDTO, HttpStatus.OK);
    }

    @GetMapping("/airline/{airline}")
    public ResponseEntity<List<FlightDTO>> getFlightByAirline(@PathVariable String airline){
        List<FlightDTO> flightList = flightService.getFlightByAirline(airline);
        if(flightList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(flightList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String destination) {

        if (source == null && destination == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        List<FlightDTO> flightList;
        if(source!=null && destination!=null){
            flightList = flightService.getFlightBySourceAndDestination(source, destination);
        } else if (destination==null) {
            flightList = flightService.getFlightBySource(source);
        } else {
            flightList = flightService.getFlightByDestination(destination);
        }

        if(flightList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flightList);

    }

    @PostMapping
    public ResponseEntity<?> createFlight(@RequestBody @Valid FlightCreationDTO flightCreationDTO, BindingResult result){
        if (result.hasErrors()) {
            String errors = result.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            FlightDTO createdFlight = flightService.createFlight(flightCreationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
        } catch (DuplicateFlightNumberException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }


}
