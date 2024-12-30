package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Room;
import com.Lost_Oasis.Models.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomImageRepository extends JpaRepository<RoomImage, Integer> {
    List<RoomImage> findByRoom(Room room);
}