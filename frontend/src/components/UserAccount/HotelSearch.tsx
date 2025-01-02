import React, { useState } from 'react';
import axios from 'axios';

// Define the interface for the hotel object
interface Hotel {
  name: string;
  location: string;
  rooms: {
    price: number;
  }[];
}

const HotelSearch: React.FC = () => {
  const [location, setLocation] = useState('');
  const [priceRange, setPriceRange] = useState('');
  const [hotels, setHotels] = useState<Hotel[]>([]); // Use the Hotel interface for proper typing

  const handleSearch = () => {
    axios
      .get(`http://localhost:8081/hotel/searching`, {
        params: { keyword: location },
      })
      .then((response) => setHotels(response.data))
      .catch((error) => console.error('Error searching hotels:', error));
  };

  const handleFilter = () => {
    const [minPrice, maxPrice] = priceRange.split('-').map(Number); // Parse prices as numbers
    axios
      .get(`http://localhost:8081/hotel/filtering`, {
        params: { location, minPrice, maxPrice, minRating: 4 },
      })
      .then((response) => setHotels(response.data))
      .catch((error) => console.error('Error filtering hotels:', error));
  };

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
        placeholder="Price Range (e.g., 100-300)"
        value={priceRange}
        onChange={(e) => setPriceRange(e.target.value)}
      />
      <button onClick={handleSearch}>Search</button>
      <button onClick={handleFilter}>Filter</button>

      <div className="hotel-list">
        {hotels.length > 0 ? (
          hotels.map((hotel, index) => (
            <div className="hotel-item" key={index}>
              <h3>{hotel.name}</h3>
              <p>{hotel.location}</p>
              <p>${hotel.rooms[0]?.price || 'N/A'}</p>
            </div>
          ))
        ) : (
          <p>No hotels found</p>
        )}
      </div>
    </div>
  );
};

export default HotelSearch;
