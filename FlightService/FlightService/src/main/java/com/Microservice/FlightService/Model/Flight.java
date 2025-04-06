package com.Microservice.FlightService.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Airline is required")
    private String airline;

    @Column(nullable = false, length = 20, unique = true)
    @NotBlank(message = "Flight number is required")
    private String flightNumber;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Source is required")
    private String source;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Destination is required")
    private String destination;

    @Column(nullable = false)
    @Min(value = 1, message = "Distance must be positive")
    private int distance;

    @Column(nullable = false)
    @Min(value = 1, message = "Duration must be positive")
    private int duration;
}
