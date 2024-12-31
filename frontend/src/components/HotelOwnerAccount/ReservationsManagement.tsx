import React from 'react';

const ReservationsManagement = () => {
  const reservations = [
    { user: 'User A', checkIn: '2024-01-01', checkOut: '2024-01-05', status: 'Pending' },
    { user: 'User B', checkIn: '2024-02-10', checkOut: '2024-02-15', status: 'Confirmed' },
  ];

  return (
    <div className="reservations-management-container">
      <h2>Manage Reservations</h2>
      {reservations.map((reservation, index) => (
        <div key={index} className="reservation-item">
          <h3>{reservation.user}</h3>
          <p>Check-in: {reservation.checkIn}</p>
          <p>Check-out: {reservation.checkOut}</p>
          <p>Status: {reservation.status}</p>
          <button>Accept</button>
          <button>Reject</button>
        </div>
      ))}
    </div>
  );
};

export default ReservationsManagement;