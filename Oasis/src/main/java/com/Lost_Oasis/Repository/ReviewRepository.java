package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByUser_UserId(int userId);
    List<Review> findByHotel_HotelId(int hotelId);
    List<Review> findByBooking_BookingId(int bookingId);
}