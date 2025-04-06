package com.Microservice.FlightService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {
    private Long id;
    private String airline;
    private String flightNumber;
    private String source;
    private String destination;
    private int distance;
    private int duration;
}