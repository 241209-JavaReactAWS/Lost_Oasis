package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByOwner(User owner);

    List<Hotel> filterByCriteria(String location, Double minPrice, Double maxPrice, Integer minRating);

    List<Hotel> searchByKeyword(String keyword);
}