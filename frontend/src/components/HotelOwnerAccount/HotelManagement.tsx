import React, { useState } from 'react';

const HotelManagement = () => {
  const [hotelName, setHotelName] = useState('');
  const [hotelDescription, setHotelDescription] = useState('');

  return (
    <div className="hotel-management-container">
      <h2>Manage Hotel Details</h2>
      <input
        type="text"
        placeholder="Hotel Name"
        value={hotelName}
        onChange={(e) => setHotelName(e.target.value)}
      />
      <textarea
        placeholder="Description"
        value={hotelDescription}
        onChange={(e) => setHotelDescription(e.target.value)}
      />
      <button>Save</button>
    </div>
  );
};

export default HotelManagement;