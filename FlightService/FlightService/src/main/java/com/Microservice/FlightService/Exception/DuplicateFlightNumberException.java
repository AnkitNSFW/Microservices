package com.Microservice.FlightService.Exception;


public class DuplicateFlightNumberException extends RuntimeException {
    public DuplicateFlightNumberException(String message) {
        super(message);
    }
}