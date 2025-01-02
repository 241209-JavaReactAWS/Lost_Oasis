package com.Lost_Oasis.Services;
import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Repository.HotelRepository;
import com.Lost_Oasis.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;

    public HotelService(HotelRepository hotelRepository, UserRepository userRepository) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Hotel createHotel(Hotel hotel, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        hotel.setUser(user);
        return hotelRepository.save(hotel);
    }

    //find all Hotel
    public List<Hotel> findAllHotel(){
        return hotelRepository.findAll();
    }
    //find Hotel by id

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
