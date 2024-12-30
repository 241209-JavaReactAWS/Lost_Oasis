package com.Lost_Oasis.Service;
import com.Lost_Oasis.Models.Favorite;
import com.Lost_Oasis.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    // Add a favorite hotel for a user
    public Favorite addFavorite(int userId, int hotelId) {
        // Check if the favorite already exists to prevent duplicates
        if (favoriteRepository.findByUserIdAndHotelId(userId, hotelId) != null) {
            throw new IllegalArgumentException("Favorite already exists.");
        }
        Favorite favorite = new Favorite();
        return favoriteRepository.save(favorite);
    }
    // Remove a favorite hotel for a user
    public void removeFavorite(int userId, int hotelId) {
        Favorite favorite = favoriteRepository.findByUserIdAndHotelId(userId, hotelId);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        } else {
            throw new IllegalArgumentException("Favorite not found.");
        }
    }
    //find all favorites of a specific user
    public List<Favorite> FindAllFavorites(){
        return favoriteRepository.findAll();
    }

}
