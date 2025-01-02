package com.Lost_Oasis.Services;

import com.Lost_Oasis.Models.RoomImage;
import com.Lost_Oasis.Models.Room;
import com.Lost_Oasis.Repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomImageService {

    @Autowired
    private RoomImageRepository roomImageRepository;

    // Create or Save a RoomImage
    public RoomImage createRoomImage(RoomImage roomImage) {
        return roomImageRepository.save(roomImage);
    }

    // find RoomImage by ID
    public Optional<RoomImage> getRoomImageById(int roomImageId) {
        return roomImageRepository.findById(roomImageId);
    }

    // find all RoomImages for a specific Room
    public List<RoomImage> getRoomImagesByRoom(Room room) {
        return roomImageRepository.findByRoom(room);
    }

    // find all RoomImages
    public List<RoomImage> getAllRoomImages() {
        return roomImageRepository.findAll();
    }

    // Update a RoomImage
    public RoomImage updateRoomImage(int roomImageId, RoomImage updatedRoomImage) {
        return roomImageRepository.findById(roomImageId).map(roomImage -> {
            roomImage.setImageUrl(updatedRoomImage.getImageUrl());
            roomImage.setRoom(updatedRoomImage.getRoom());
            return roomImageRepository.save(roomImage);
        }).orElseThrow(() -> new IllegalArgumentException("RoomImage with ID " + roomImageId + " not found"));
    }

    // Delete a RoomImage
    public void deleteRoomImage(int roomImageId) {
        if (roomImageRepository.existsById(roomImageId)) {
            roomImageRepository.deleteById(roomImageId);
        } else {
            throw new IllegalArgumentException("RoomImage with ID " + roomImageId + " not found");
        }
    }
}