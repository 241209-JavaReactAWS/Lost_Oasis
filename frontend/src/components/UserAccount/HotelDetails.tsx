import React from 'react';

const HotelDetails = () => {
  return (
    <div className="hotel-details-container">
      <h2>Hotel Details</h2>
      <img src="hotel-image.jpg" alt="Hotel" />
      <p>Location: New York</p>
      <p>Price: $200/night</p>
      <p>Amenities: WiFi, Pool, Gym</p>
      <button>Book Now</button>
    </div>
  );
};

export default HotelDetails;