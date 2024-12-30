package com.Lost_Oasis.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "hotelImage")
public class HotelImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelImageId;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    private String imageUrl;

    public HotelImage(){
    }

    public HotelImage(int hotelImageId, Hotel hotel, String imageUrl) {
        this.hotelImageId = hotelImageId;
        this.hotel = hotel;
        this.imageUrl = imageUrl;
    }

    public int getHotelImageId() {
        return hotelImageId;
    }

    public void setHotelImageId(int hotelImageId) {
        this.hotelImageId = hotelImageId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
