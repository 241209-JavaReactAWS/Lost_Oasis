package com.Lost_Oasis.Repository;

import com.Lost_Oasis.Models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}