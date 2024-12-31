package com.Lost_Oasis.Services;

import com.Lost_Oasis.Models.Review;
import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.Booking;
import com.Lost_Oasis.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create or Save a Review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // find Review by ID
    public Optional<Review> getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    // find all Reviews for a specific User
    public List<Review> getReviewsByUser(int userId) {
        return reviewRepository.findByUser_UserId(userId);
    }

    // find all Reviews for a specific Hotel
    public List<Review> getReviewsByHotel(int hotelId) {
        return reviewRepository.findByHotel_HotelId(hotelId);
    }

    // find all Reviews for a specific Booking
    public List<Review> getReviewsByBooking(int bookingId) {
        return reviewRepository.findByBooking_BookingId(bookingId);
    }

    // find all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Delete a Review
    public void deleteReview(int reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        } else {
            throw new IllegalArgumentException("Review with ID " + reviewId + " not found");
        }
    }
}