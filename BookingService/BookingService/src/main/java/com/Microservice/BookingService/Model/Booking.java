package com.Microservice.BookingService.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Schedule ID must not be null")
    private Long scheduleId;

    @Column(nullable = false)
    @NotNull(message = "User ID must not be null")
    private Long userId;

    @Column(nullable = false)
    @NotNull(message = "Status must not be null")
    private String status; // e.g., "Confirmed", "Pending", "Cancelled"

    @Column(nullable = false)
    @NotNull(message = "Creation time must not be null")
    private LocalDateTime createdAt;

}