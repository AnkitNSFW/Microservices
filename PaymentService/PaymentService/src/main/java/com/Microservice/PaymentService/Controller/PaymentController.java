package com.Microservice.PaymentService.Controller;


import com.Microservice.PaymentService.DTO.PaymentDTO;
import com.Microservice.PaymentService.Service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paymnet")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentDTO createPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
        return paymentService.createPayment(paymentDTO);
    }

    @GetMapping("/{paymentId}")
    public PaymentDTO getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/booking/{bookingId}")
    public PaymentDTO getPaymentByBooking(@PathVariable Long bookingId) {
        return paymentService.getPaymentByBookingId(bookingId);
    }

    @PutMapping("/{paymentId}")
    public PaymentDTO updatePayment(@PathVariable Long paymentId,
                                    @Valid @RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePayment(paymentId, paymentDTO);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
