package com.Microservice.PaymentService.Mapper;

import com.Microservice.PaymentService.DTO.PaymentDTO;
import com.Microservice.PaymentService.Model.Payment;

public class PaymentMapper {
    public static PaymentDTO toDto(Payment payment) {
        if (payment == null) {
            return null;
        }
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setBookingId(payment.getBookingId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        return dto;
    }

    public static Payment toEntity(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }
        Payment payment = new Payment();
        // For new payments, id and createdAt are auto-generated.
        payment.setBookingId(dto.getBookingId());
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());
        return payment;
    }

}
