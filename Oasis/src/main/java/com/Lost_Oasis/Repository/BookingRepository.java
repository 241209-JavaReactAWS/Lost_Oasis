package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}