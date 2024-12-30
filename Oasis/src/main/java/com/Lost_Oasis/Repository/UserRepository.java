package com.Lost_Oasis.DAOs;

import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO  extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
