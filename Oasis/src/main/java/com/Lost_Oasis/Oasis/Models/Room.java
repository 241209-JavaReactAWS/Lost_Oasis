package com.Lost_Oasis.Oasis.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private int guest;

    @Column(nullable = false)
    private int inventory;

    public Room(){
    }

    public Room(int roomId, Hotel hotel, double price, String roomType, int guest, int inventory) {
        this.roomId = roomId;
        this.hotel = hotel;
        this.price = price;
        this.roomType = roomType;
        this.guest = guest;
        this.inventory = inventory;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}