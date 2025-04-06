package com.Microservice.BookingService.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;

    @NotNull(message = "Schedule ID is required")
    private Long scheduleId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Status is required")
    private String status;
}
