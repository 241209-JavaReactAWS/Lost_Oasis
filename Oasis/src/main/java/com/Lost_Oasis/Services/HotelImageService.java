package com.Lost_Oasis.Services;


import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.HotelImage;
import com.Lost_Oasis.Repository.HotelImageRepository;


import java.util.List;
import java.util.Optional;

public class HotelImageService {
    private final HotelImageRepository hotelImageRepository;

    public HotelImageService(HotelImageRepository hotelImageRepository) {
        this.hotelImageRepository = hotelImageRepository;
    }
//delete HotelImage
    public void deleteHotelImage(int hotelImageID){
        if (hotelImageRepository.existsById(hotelImageID)) {
            hotelImageRepository.deleteById(hotelImageID);
        } else {
            throw new IllegalArgumentException("HotelImage with ID " + hotelImageID + " not found");
        }
    }
    //Create HotelImages
    public HotelImage CreateHotelImage(HotelImage hotelImage){
       return hotelImageRepository.save(hotelImage);
    }
    //find all HotelImages
    public List<HotelImage> findAllHotelImages(){
        return hotelImageRepository.findAll();
    }

    // find a hotel image by its ID
    public Optional<HotelImage> getHotelImageById(int hotelImageId) {
        return hotelImageRepository.findById(hotelImageId);
    }

    // find all images for a specific hotel
    public List<HotelImage> getImagesByHotel(Hotel hotel) {
        return hotelImageRepository.findByHotel(hotel);
    }

    // Update an existing hotel image
    public HotelImage updateHotelImage(int hotelImageId, HotelImage updatedImage) {
        Optional<HotelImage> existingImage = hotelImageRepository.findById(hotelImageId);
        if (existingImage.isPresent()) {
            HotelImage hotelImage = existingImage.get();
            hotelImage.setImageUrl(updatedImage.getImageUrl());
            hotelImage.setHotel(updatedImage.getHotel());
            return hotelImageRepository.save(hotelImage);
        } else {
            throw new IllegalArgumentException("Hotel Image with ID " + hotelImageId + " not found");
        }
    }
}
