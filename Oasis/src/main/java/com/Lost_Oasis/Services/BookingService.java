package com.Lost_Oasis.Services;

import com.Lost_Oasis.DTO.BookingRequest;
import com.Lost_Oasis.Models.*;
import com.Lost_Oasis.Repository.BookingRepository;
import com.Lost_Oasis.Repository.HotelRepository;
import com.Lost_Oasis.Repository.RoomRepository;
import com.Lost_Oasis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;


    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }
    //Create booking
    public void createBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setCheckIn(bookingRequest.getCheckIn());
        booking.setCheckOut(bookingRequest.getCheckOut());
        booking.setCreatedBy(LocalDateTime.now());
        booking.setLastUpdateBy(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);

        // Fetch related entities
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));
        Room room = roomRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        User owner = userRepository.findById(bookingRequest.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        booking.setUser(user);
        booking.setHotel(hotel);
        booking.setRoom(room);
        booking.setOwner(owner);

        bookingRepository.save(booking);

}

    //find all booking
    public List<Booking> findAllBooking(){
        return bookingRepository.findAll();
 }

    // find by ID
    public Optional<Booking> findBookingByID(int BookingId){
        return bookingRepository.findById(BookingId);
    }

    // find by user ID
    public Optional<Booking> findBookingByUser (int userID){
        return bookingRepository.findById(userID);
    }

    // find by hotel ID
    public Optional<Booking> findBookingByHotel (int hotelID){
        return bookingRepository.findById(hotelID);
    }

    // find by room ID
    public Optional<Booking> findBookingByRoom (int roomID){
        return bookingRepository.findById(roomID);
    }

    // delete booking
    public int deleteBooking(int BookingId){
        bookingRepository.deleteById(BookingId);
        return 0;
    }
}
