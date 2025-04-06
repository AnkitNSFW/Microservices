package com.Microservice.BookingService.Controller;

import com.Microservice.BookingService.DTO.BookingDTO;
import com.Microservice.BookingService.Model.Booking;
import com.Microservice.BookingService.Service.BookingService;
import jakarta.validation.Valid;
import org.hibernate.dialect.lock.PessimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<BookingDTO>  getBookingById(@PathVariable Long Id) {
        BookingDTO bookingDTO =  bookingService.getBookingById(Id);
        if(bookingDTO==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookingDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUser(@PathVariable Long userId) {
        List<BookingDTO> bookingDTOList = bookingService.getBookingsByUser(userId);
        if(bookingDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookingDTOList);
    }

    @PutMapping("status/{bookingId}")
    public BookingDTO updateBookingStatus(@PathVariable Long bookingId, @RequestParam String status) {
        return bookingService.updateBookingStatus(bookingId, status);
    }
}
