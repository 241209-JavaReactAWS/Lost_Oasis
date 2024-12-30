package com.Lost_Oasis.Service;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a New User
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // find User by ID
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    // find User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update User Details
    public User updateUser(int userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(updatedUser.getPassword());
            }
            user.setImageUrl(updatedUser.getImageUrl());
            user.setRole(updatedUser.getRole());
            user.setFavorites(updatedUser.getFavorites());
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found"));
    }

    // Delete User
    public void deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }

    // Add Hotel to Favorites
    public User addFavoriteHotel(int userId, Hotel hotel) {
        return userRepository.findById(userId).map(user -> {
            user.getFavorites().add(hotel);
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found"));
    }

    // Remove Hotel from Favorites
    public User removeFavoriteHotel(int userId, Hotel hotel) {
        return userRepository.findById(userId).map(user -> {
            user.getFavorites().remove(hotel);
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found"));
    }
}