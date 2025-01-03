package com.Lost_Oasis.Services;

import com.Lost_Oasis.Models.Hotel;
import com.Lost_Oasis.Repository.HotelRepository;
import com.Lost_Oasis.Repository.UserRepository;
import com.Lost_Oasis.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final HotelRepository hotelRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, HotelRepository hotelRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.hotelRepository = hotelRepository;
    }

    public User createNewUser(User user){
        User account = userRepository.findByEmail(user.getEmail());

        if(account == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }


    public User loginUser(User user){
        User account = userRepository.findByEmail(user.getEmail());
        if(account != null && passwordEncoder.matches(user.getPassword(), account.getPassword())){
            return account;
        }
        return null;
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void updateUser(int userId, User user){
//<<<<<<< HEAD
        User oldUser = userRepository.findByUserId(user.getUserId());

        if(oldUser != null){
            oldUser.setImageUrl(user.getImageUrl());
            oldUser.setName(user.getName());
        }
//=======
        assert oldUser != null;
        oldUser.setImageUrl(user.getImageUrl());
        oldUser.setName(user.getName());
//>>>>>>> main
    }

    public User addHotelToFavorite(int userId, int hotelId) {
        User possibleUser = userRepository.findByUserId(userId);
        Hotel possibleHotel = hotelRepository.findByHotelId(hotelId);

        if(possibleUser == null || possibleHotel == null){
            return null;
        }

        Set<Hotel> favorites = possibleUser.getFavorites();
        favorites.add(possibleHotel);
        possibleUser.setFavorites(favorites);

        return userRepository.save(possibleUser);
    }

    public User deleteHotelFromFavorite(int userId, int hotelId) {
        User possibleUser = userRepository.findByUserId(userId);
        Hotel possibleHotel = hotelRepository.findByHotelId(hotelId);

        Set<Hotel> favorites = possibleUser.getFavorites();
        favorites.remove(possibleHotel);
        possibleUser.setFavorites(favorites);

        return userRepository.save(possibleUser);
    }

}
