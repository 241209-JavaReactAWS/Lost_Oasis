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
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    // find all Reviews for a specific User
    public List<Review> getReviewsByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    // find all Reviews for a specific Hotel
    public List<Review> getReviewsByHotel(Hotel hotel) {
        return reviewRepository.findByHotel(hotel);
    }

    // find all Reviews for a specific Booking
    public List<Review> getReviewsByBooking(Booking booking) {
        return reviewRepository.findByBooking(booking);
    }

    // find all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Delete a Review
    public void deleteReview(Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        } else {
            throw new IllegalArgumentException("Review with ID " + reviewId + " not found");
        }
    }
}