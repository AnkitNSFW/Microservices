package com.Microservice.BookingService.Mapper;

import com.Microservice.BookingService.DTO.BookingDTO;
import com.Microservice.BookingService.Model.Booking;

public class BookingMapper {

    // Convert Booking entity to BookingDTO
    public static BookingDTO toDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setScheduleId(booking.getScheduleId());
        dto.setUserId(booking.getUserId());
        dto.setStatus(booking.getStatus());
        return dto;
    }

    // Convert BookingDTO to Booking entity
    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) {
            return null;
        }
        Booking booking = new Booking();
        // Note: ID is auto-generated; we do not map it from DTO in creation scenarios
        booking.setScheduleId(dto.getScheduleId());
        booking.setUserId(dto.getUserId());
        booking.setStatus(dto.getStatus());
        return booking;
    }
}