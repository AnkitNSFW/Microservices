package com.Microservice.FlightService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightWithSchedulesDTO {
    private Long id;
    private String airline;
    private String flightNumber;
    private String source;
    private String destination;
    private int distance;
    private int duration;
    private List<ScheduleDTO> schedules;
}
