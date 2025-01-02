import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

interface Hotel {
  name: string;
  location: string;
  address: string;
  owner: {
    name: string;
  };
  rooms: {
    price: number;
  }[];
}

const HotelDetails = () => {
  const { id } = useParams(); // Get hotel ID from URL
  const [hotel, setHotel] = useState<Hotel | null>(null); // Use proper typing

  useEffect(() => {
    axios
      .get(`http://localhost:8081/hotel/${id}`)
      .then((response) => setHotel(response.data))
      .catch((error) => console.error('Error fetching hotel details:', error));
  }, [id]);

  if (!hotel) return <p>Loading...</p>; // Handle loading state

  return (
    <div className="hotel-details-container">
      <h2>{hotel.name}</h2>
      <p>Location: {hotel.location}</p>
      <p>Address: {hotel.address}</p>
      <p>Owner: {hotel.owner.name}</p>
      <p>
        Price Range: ${hotel.rooms[0]?.price} - $
        {hotel.rooms[hotel.rooms.length - 1]?.price}
      </p>
    </div>
  );
};

export default HotelDetails;
