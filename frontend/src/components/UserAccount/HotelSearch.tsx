import React, { useState } from 'react';

const HotelSearch = () => {
  const [location, setLocation] = useState('');
  const [priceRange, setPriceRange] = useState('');
  const [hotels, setHotels] = useState([
    // Sample hotel data
    { name: 'Hotel A', location: 'New York', price: 200 },
    { name: 'Hotel B', location: 'Paris', price: 300 },
  ]);

  return (
    <div className="search-container">
      <h2>Search Hotels</h2>
      <input
        type="text"
        placeholder="Location"
        value={location}
        onChange={(e) => setLocation(e.target.value)}
      />
      <input
        type="text"
        placeholder="Price Range"
        value={priceRange}
        onChange={(e) => setPriceRange(e.target.value)}
      />
      <button>Search</button>

      <div className="hotel-list">
        {hotels.map((hotel, index) => (
          <div className="hotel-item" key={index}>
            <h3>{hotel.name}</h3>
            <p>{hotel.location}</p>
            <p>${hotel.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default HotelSearch;