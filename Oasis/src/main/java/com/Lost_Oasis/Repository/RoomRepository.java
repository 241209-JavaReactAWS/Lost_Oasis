package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}