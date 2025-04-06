package com.Microservice.PaymentService.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue()
    private Long id;

    @NotNull(message = "Booking ID is required")
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "Status is required")
    @Column(nullable = false, length = 20)
    private String status; // e.g., "Paid", "Pending", "Failed"

    @NotNull(message = "Created At is required")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
