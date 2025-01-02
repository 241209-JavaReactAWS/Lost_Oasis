package com.Lost_Oasis.Services;

import com.Lost_Oasis.Models.Notification;
import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Models.Booking;
import com.Lost_Oasis.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Create a new notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // find a notification by its ID
    public Optional<Notification> getNotificationById(int notificationId) {
        return notificationRepository.findById(notificationId);
    }

    // find all notifications for a specific user
    public List<Notification> getNotificationsByUser(User user) {
        return notificationRepository.findByUser(user);
    }

    // find all notifications associated with a specific booking
    public List<Notification> getNotificationsByBooking(Booking booking) {
        return notificationRepository.findByBooking(booking);
    }

    // find all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Marking a notification as read
    public Notification markAsRead(int notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isPresent()) {
            Notification notif = notification.get();
            notif.setRead(true);
            return notificationRepository.save(notif);
        } else {
            throw new IllegalArgumentException("Notification with ID " + notificationId + " not found");
        }
    }

    // Delete a notification by its ID
    public void deleteNotification(int notificationId) {
        if (notificationRepository.existsById(notificationId)) {
            notificationRepository.deleteById(notificationId);
        } else {
            throw new IllegalArgumentException("Notification with ID " + notificationId + " not found");
        }
    }
}