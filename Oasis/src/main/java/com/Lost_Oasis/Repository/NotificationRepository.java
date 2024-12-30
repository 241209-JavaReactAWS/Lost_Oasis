package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Booking;
import com.Lost_Oasis.Models.Notification;
import com.Lost_Oasis.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUser(User user);

    List<Notification> findByBooking(Booking booking);
}