package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByUserId(int userId);
}
