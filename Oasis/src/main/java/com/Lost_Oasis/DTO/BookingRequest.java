package com.Lost_Oasis.DTO;

import java.time.LocalDate;



    public class BookingRequest {

        private LocalDate checkIn;  // Check-in date for the booking
        private LocalDate checkOut; // Check-out date for the booking
        private int userId;         // ID of the user making the booking
        private int hotelId;        // ID of the hotel being booked
        private int roomId;         // ID of the room being booked
        private int ownerId;        // ID of the owner of the hotel

        // Getters and Setters
        public LocalDate getCheckIn() {
            return checkIn;
        }

        public void setCheckIn(LocalDate checkIn) {
            this.checkIn = checkIn;
        }

        public LocalDate getCheckOut() {
            return checkOut;
        }

        public void setCheckOut(LocalDate checkOut) {
            this.checkOut = checkOut;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getHotelId() {
            return hotelId;
        }

        public void setHotelId(int hotelId) {
            this.hotelId = hotelId;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }
    }


