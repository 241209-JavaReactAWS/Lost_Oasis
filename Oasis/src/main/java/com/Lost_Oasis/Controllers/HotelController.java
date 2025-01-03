package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//
//@RestController
//@RequestMapping("api/v1/hotel")
//public class HotelController {
//
//    private final HotelService hotelService;
//
//    @Autowired
//    public HotelController(HotelService hotelService){
//        this.hotelService = hotelService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
//        // userId will be extracted from Auth
//        Integer userId = 1;
//        Hotel createdHotel = hotelService.createHotel(hotel, userId);
//        return ResponseEntity.ok(createdHotel);
//    }
//}



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
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no hotels are found
        }
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