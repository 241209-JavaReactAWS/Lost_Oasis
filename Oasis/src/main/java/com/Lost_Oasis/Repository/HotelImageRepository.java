package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelImageRepository extends JpaRepository<HotelImage, Integer> {
    List<HotelImage> findByHotel(Hotel hotel);
}