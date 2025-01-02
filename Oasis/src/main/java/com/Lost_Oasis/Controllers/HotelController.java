package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import com.Lost_Oasis.Services.HotelService;

import java.util.List;


@RestController
    @RequestMapping("/hotel")
    public class HotelController {

        private final HotelService hotelService;

               //Constructor-based injection
    @Autowired
    public HotelController(HotelService hotelService) {
         this.hotelService = hotelService;
    }

    // Retrieve all hotels
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.findAllHotel();
        return ResponseEntity.ok(hotels);
    }

    //Endpoint to create a new hotel
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel createdHotel = hotelService.createHotel(hotel);
            return new ResponseEntity<>(createdHotel, HttpStatus.CREATED); // Return 201 Created with the created hotel
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Return 400 Bad Request if something goes wrong
        }
    }

        // Searching hotels by keyword
        @GetMapping("/searching")
        public ResponseEntity<List<Hotel>> searchHotels(@RequestParam String keyword) {
            List<Hotel> hotels = hotelService.searchByKeyword(keyword);
            return ResponseEntity.ok(hotels);
        }

        // Filtering hotels by location, price range, and review
        @GetMapping("/filtering")
        public ResponseEntity<List<Hotel>> filterHotels(
                @RequestParam(required = false) String location,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Integer minRating) {

            // Delegate the filtering logic to the service
            List<Hotel> hotels = hotelService.filterHotels(location, minPrice, maxPrice, minRating);
            return ResponseEntity.ok(hotels);
        }
}



