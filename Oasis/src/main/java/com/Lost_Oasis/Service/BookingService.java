package com.Lost_Oasis.Service;

import com.Lost_Oasis.Models.Booking;
import com.Lost_Oasis.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
   //Create booking
    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    //find all booking
 public List<Booking> findAllBooking(){
        return bookingRepository.findAll();
 }
 // find by ID
    public Optional<Booking> findBookingByID(int Bookingid){
        return bookingRepository.findById(Bookingid);
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
    public int deleteBooking(int Bookingid){
        bookingRepository.deleteById(Bookingid);
        return 0;
    }
}
