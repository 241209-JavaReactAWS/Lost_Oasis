package com.Lost_Oasis.Services;

import com.Lost_Oasis.repository.UserRepository;
import com.Lost_Oasis.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public User createNewUser(User user){
        User account = userRepository.findByEmail(user.getEmail());
        if(account == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userDAO.save(user);
        }
        return null;
    }

    public User loginUser(User user){
        User account = userDAO.findByEmail(user.getEmail());
        if(account != null && passwordEncoder.matches(user.getPassword(), account.getPassword())){
            return account;
        }
        return null;
    }
}
