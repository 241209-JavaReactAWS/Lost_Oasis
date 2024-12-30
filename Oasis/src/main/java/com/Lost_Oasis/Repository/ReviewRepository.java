package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}