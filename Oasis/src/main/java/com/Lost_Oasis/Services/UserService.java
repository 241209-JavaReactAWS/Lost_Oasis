package com.Lost_Oasis.Services;

import com.Lost_Oasis.DAOs.UserDAO;
import com.Lost_Oasis.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder){
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public User createNewUser(User user){
        User account = userDAO.findByEmail(user.getEmail());
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
