package com.Lost_Oasis.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "roomImage")
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomImageId;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    private String imageUrl;

    public RoomImage(){
    }

    public RoomImage(int roomImageId, Room room, String imageUrl) {
        this.roomImageId = roomImageId;
        this.room = room;
        this.imageUrl = imageUrl;
    }

    public int getRoomImageId() {
        return roomImageId;
    }

    public void setRoomImageId(int roomImageId) {
        this.roomImageId = roomImageId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
