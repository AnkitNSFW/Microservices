package com.Microservice.PaymentService.Service;

import com.Microservice.PaymentService.DTO.PaymentDTO;
import com.Microservice.PaymentService.Mapper.PaymentMapper;
import com.Microservice.PaymentService.Model.Payment;
import com.Microservice.PaymentService.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = PaymentMapper.toEntity(paymentDTO);
        Payment savedPayment = paymentRepo.save(payment);
        return PaymentMapper.toDto(savedPayment);
    }

    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        return PaymentMapper.toDto(payment);
    }

    public PaymentDTO getPaymentByBookingId(Long bookingId) {
        Payment payment = paymentRepo.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Payment not found for booking id: " + bookingId));
        return PaymentMapper.toDto(payment);
    }

    // Update a payment (e.g., update status or amount if needed)
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        // Update fields. Typically, bookingId and createdAt should not change.
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus());
        Payment updatedPayment = paymentRepo.save(payment);
        return PaymentMapper.toDto(updatedPayment);
    }

    public void deletePayment(Long id) {
        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        paymentRepo.delete(payment);
    }
}
