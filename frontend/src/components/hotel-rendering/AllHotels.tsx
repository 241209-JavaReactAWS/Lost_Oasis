import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AllHotels: React.FC = () => {
  const [hotels, setHotels] = useState<any[]>([]);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    axios.get('http://localhost:8081/hotel/all')
      .then(response => {
        console.log('Hotels fetched successfully:', response.data);
        setHotels(response.data);
        setError(null);
      })
      .catch(err => {
        console.error('Error fetching hotels:', err);
        setError('Failed to fetch hotels. Please try again later.');
      });
  }, []);

  return (
    <div className="container">
      <h2 className="text-center mt-4">Our Hotels</h2>
      {error ? (
        <div className="alert alert-danger">{error}</div>
      ) : (
        <div className="row">
          {hotels.map((hotel, index) => (
            <div key={index} className="col-md-4 mb-4">
              <div className="card">
                <img
                  src={hotel.imageUrl || '/default-hotel.jpg'} // Add default image if none exists
                  className="card-img-top"
                  alt={hotel.name}
                />
                <div className="card-body">
                  <h5 className="card-title">{hotel.name}</h5>
                  <p className="card-text">{hotel.location}</p>
                  <p className="card-text">{hotel.address}</p>
                  <a href={`/hotel/${hotel.hotelId}`} className="btn btn-primary">
                    View Details
                  </a>
                </div>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default AllHotels;
