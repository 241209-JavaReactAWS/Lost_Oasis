package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.*;
import com.Lost_Oasis.Repository.BookingRepository;
import com.Lost_Oasis.Repository.HotelRepository;
import com.Lost_Oasis.Repository.RoomRepository;
import com.Lost_Oasis.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class BookingController {

    UserRepository userRepository;
    HotelRepository hotelRepository;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;


    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setCheckIn(bookingRequest.getCheckIn());
        booking.setCheckOut(bookingRequest.getCheckOut());
        booking.setCreatedBy(LocalDateTime.now());
        booking.setLastUpdateBy(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);

        // Fetch and set related entities
        User user = userRepository.findById(bookingRequest.getUserId()).orElseThrow();
        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId()).orElseThrow();
        Room room = roomRepository.findById(bookingRequest.getRoomId()).orElseThrow();
        User owner = userRepository.findById(bookingRequest.getOwnerId()).orElseThrow();

        booking.setUser(user);
        booking.setHotel(hotel);
        booking.setRoom(room);
        booking.setOwner(owner);

        bookingRepository.save(booking);
        return ResponseEntity.ok("Booking created successfully!");
    }

}
