package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        // userId will be extracted from Auth
        Integer userId = 1;
        Hotel createdHotel = hotelService.createHotel(hotel, userId);
        return ResponseEntity.ok(createdHotel);
    }
}
