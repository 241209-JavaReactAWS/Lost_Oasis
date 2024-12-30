package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}