package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.DTO.BookingRequest;
import com.Lost_Oasis.Models.*;
import com.Lost_Oasis.Repository.BookingRepository;
import com.Lost_Oasis.Repository.HotelRepository;
import com.Lost_Oasis.Repository.RoomRepository;
import com.Lost_Oasis.Repository.UserRepository;
import com.Lost_Oasis.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest) {
        bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok("Booking created successfully!");
    }

}