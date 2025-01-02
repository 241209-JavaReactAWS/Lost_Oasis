package com.Lost_Oasis.Services;

import com.Lost_Oasis.Repository.UserRepository;
import com.Lost_Oasis.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createNewUser(User user){
        User account = userRepository.findByEmail(user.getEmail());

        if(account == null){
            System.out.println("created");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        System.out.println("failed");
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
    public void updateUser(User user){
        User oldUser = userRepository.findByUserId(user.getUserId());

        if(oldUser != null){
            oldUser.setImageUrl(user.getImageUrl());
            oldUser.setName(user.getName());
        }
    }
}
