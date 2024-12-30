package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUserId(int userId);

    Favorite findByUserIdAndHotelId(int userId, int hotelId);

    void deleteByUserIdAndHotelId(int userId, int hotelId);
}