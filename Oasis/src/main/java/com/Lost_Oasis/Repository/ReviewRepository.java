package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Booking;
import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.Review;
import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(User user);

    List<Review> findByHotel(Hotel hotel);

    List<Review> findByBooking(Booking booking);
}