package com.Microservice.BookingService.Service;

import com.Microservice.BookingService.DTO.BookingDTO;
import com.Microservice.BookingService.Exception.BookingNotFoundException;
import com.Microservice.BookingService.Mapper.BookingMapper;
import com.Microservice.BookingService.Model.Booking;
import com.Microservice.BookingService.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public List<BookingDTO> getAllBookings(){
        return bookingRepo.findAll().stream()
                .map(BookingMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setScheduleId(bookingDTO.getScheduleId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setStatus(bookingDTO.getStatus());
        booking.setCreatedAt(LocalDateTime.now());

        Booking savedBooking = bookingRepo.save(booking);
        bookingDTO.setId(savedBooking.getId());
        return bookingDTO;
    }

    // Retrieve a booking by its ID
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepo.findById(id).orElse(null);
        return BookingMapper.toDto(booking);
    }

    // Retrieve all bookings for a specific user
    public List<BookingDTO> getBookingsByUser(Long userId) {
        List<Booking> bookings = bookingRepo.findByUserId(userId);
        return bookings.stream().map(BookingMapper::toDto).collect(Collectors.toList());
    }

    // Update booking status
    public BookingDTO updateBookingStatus(Long id, String status) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        bookingRepo.save(booking);
        return BookingMapper.toDto(booking);
    }
}
