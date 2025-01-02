package com.Lost_Oasis.Services;
import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    //Create Hotel

    public Hotel createHotel(Hotel hotel){
       return hotelRepository.save(hotel);
    }
    // Delete Hotel
    public void deleteHotel(int hotelId){

        if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId);
        } else {
            throw new IllegalArgumentException("Hotel with ID " + hotelId + " not found");
        }
    }
    //find all Hotel
    public List<Hotel> findAllHotel(){
        return hotelRepository.findAll();
    }
    //find Hotel by id



    // Search hotels by keyword
    public List<Hotel> searchByKeyword(String keyword) {
        return hotelRepository.searchByKeyword(keyword);
    }
    //filtering hotels based on criteria by location, price ranges, and review, when user search hotels
    public List<Hotel> filterHotels(String location, Double minPrice, Double maxPrice, Integer minRating) {
        //Validate the input parameters (checking minPrice < maxPrice)
        if (minPrice != null && maxPrice != null) {
            throw new IllegalArgumentException("minPrice cannot be greater than maxPrice");
        }

        //Call reposiroty to fetch data
        return hotelRepository.filterByCriteria(location, minPrice, maxPrice, minRating);
    }

    public Optional<Hotel> findHotelById(int hotelID){
        return hotelRepository.findById(hotelID);
    }
    //  all hotels owned by a specific user
    public List<Hotel> getHotelsByOwner(User owner) {
        return hotelRepository.findByOwner(owner);
    }

    // Update an existing hotel's information
    public Hotel updateHotel(int hotelId, Hotel updatedHotel) {
        Optional<Hotel> existingHotel = hotelRepository.findById(hotelId);
        if (existingHotel.isPresent()) {
            Hotel hotel = existingHotel.get();
            hotel.setName(updatedHotel.getName());
            hotel.setLocation(updatedHotel.getLocation());
            hotel.setAddress(updatedHotel.getAddress());
            hotel.setImages(updatedHotel.getImages());
            return hotelRepository.save(hotel);
        } else {
            throw new IllegalArgumentException("Hotel with ID " + hotelId + " not found");
        }
    }
}
