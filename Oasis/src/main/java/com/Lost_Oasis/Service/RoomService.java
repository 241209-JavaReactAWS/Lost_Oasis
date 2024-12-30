package com.Lost_Oasis.Service;

import com.Lost_Oasis.Models.Room;
import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // Create or Save a Room
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // find Room by ID
    public Optional<Room> getRoomById(int roomId) {
        return roomRepository.findById(roomId);
    }

    // find all Rooms for a specific Hotel
    public List<Room> getRoomsByHotel(Hotel hotel) {
        return roomRepository.findByHotel(hotel);
    }

    // find all Rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Update a Room
    public Room updateRoom(int roomId, Room updatedRoom) {
        return roomRepository.findById(roomId).map(room -> {
            room.setPrice(updatedRoom.getPrice());
            room.setRoomType(updatedRoom.getRoomType());
            room.setGuest(updatedRoom.getGuest());
            room.setInventory(updatedRoom.getInventory());
            return roomRepository.save(room);
        }).orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));
    }

    // Delete a Room
    public void deleteRoom(int roomId) {
        if (roomRepository.existsById(roomId)) {
            roomRepository.deleteById(roomId);
        } else {
            throw new IllegalArgumentException("Room with ID " + roomId + " not found");
        }
    }
}