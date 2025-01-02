package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Repository.HotelRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;


@RestController
    @RequestMapping("/hotel")
    public class HotelController {

        private final HotelRepository hotelRepository;

        public HotelController(HotelRepository hotelRepository) {
            this.hotelRepository = hotelRepository;
        }

        // Searching hotels by keyword
        @GetMapping("/searching")
        public ResponseEntity<List<Hotel>> searchHotels(@RequestParam String keyword) {
            List<Hotel> hotels = hotelRepository.searchByKeyword(keyword);
            return ResponseEntity.ok(hotels);
        }

        // Filtering hotels by location, price range, and review
        @GetMapping("/filtering")
        public ResponseEntity<List<Hotel>> filterHotels(
                @RequestParam(required = false) String location,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Integer minRating) {

            List<Hotel> hotels = hotelRepository.filterByCriteria(location, minPrice, maxPrice, minRating);
            return ResponseEntity.ok(hotels);
        }
    }


