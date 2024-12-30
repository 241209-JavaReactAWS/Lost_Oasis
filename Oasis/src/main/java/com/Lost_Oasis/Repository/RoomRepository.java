package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByHotel(Hotel hotel);
}