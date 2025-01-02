package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Lost_Oasis.Models.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByOwner(User owner);


    @Query("SELECT DISTINCT h FROM Hotel h JOIN h.rooms r " +
            "WHERE (:location IS NULL OR LOWER(h.location) = LOWER(:location)) " +
            "AND (:minPrice IS NULL OR r.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR r.price <= :maxPrice) " +
            "AND (:minRating IS NULL OR (SELECT AVG(rv.rating) FROM Review rv WHERE rv.hotel.hotelId = h.hotelId) >= :minRating)")
    List<Hotel> filterByCriteria(
            @Param("location") String location,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("minRating") Integer minRating);


    @Query("SELECT h FROM Hotel h WHERE LOWER(h.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(h.location) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(h.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Hotel> searchByKeyword(@Param("keyword") String keyword);

}