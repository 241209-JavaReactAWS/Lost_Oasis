package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.Review;
import com.Lost_Oasis.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create a new review
    @PostMapping("/add")
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        try {
            Review savedReview = reviewService.createReview(review);
            return ResponseEntity.ok(savedReview);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body("Invalid rating: " + e.getMessage());
        }
    }

    // Get a review by ID
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable int reviewId) {
        Optional<Review> review = reviewService.getReviewById(reviewId);
        if (review.isPresent()) {
            return ResponseEntity.ok(review.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all reviews for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable int userId) {
        List<Review> reviews = reviewService.getReviewsByUser(userId);
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.noContent().build(); // No reviews found
        }
    }

    // Get all reviews for a specific hotel
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Review>> getReviewsByHotel(@PathVariable int hotelId) {
        List<Review> reviews = reviewService.getReviewsByHotel(hotelId);
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.noContent().build(); // No reviews found
        }
    }

    // Get all reviews for a specific booking
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Review>> getReviewsByBooking(@PathVariable int bookingId) {
        List<Review> reviews = reviewService.getReviewsByBooking(bookingId);
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.noContent().build(); // No reviews found
        }
    }

    // Get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.noContent().build(); // No reviews found
        }
    }

    // Delete a review by ID
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable int reviewId) {
        try {
            reviewService.deleteReview(reviewId);
            return ResponseEntity.ok().build(); // Successfully deleted
        } catch (IllegalArgumentException e) {
            // If the review is not found
            return ResponseEntity.notFound().build();
        }
    }
}