import React from 'react';

const UserBookings = () => {
  const bookings = [
    { hotel: 'Hotel A', checkIn: '2024-01-01', checkOut: '2024-01-05' },
    { hotel: 'Hotel B', checkIn: '2024-02-10', checkOut: '2024-02-15' },
  ];

  return (
    <div className="bookings-container">
      <h2>Your Bookings</h2>
      {bookings.map((booking, index) => (
        <div key={index} className="booking-item">
          <h3>{booking.hotel}</h3>
          <p>Check-in: {booking.checkIn}</p>
          <p>Check-out: {booking.checkOut}</p>
        </div>
      ))}
    </div>
  );
};

export default UserBookings;