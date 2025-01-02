import React from 'react';

const OwnerDashboard = () => {
  return (
    <div className="owner-dashboard-container">
      <h2>Hotel Owner Dashboard</h2>
      <button>Add New Hotel</button>
      <div className="hotel-list">
        <div className="hotel-item">
          <h3>Hotel A</h3>
          <button>Manage</button>
        </div>
        <div className="hotel-item">
          <h3>Hotel B</h3>
          <button>Manage</button>
        </div>
      </div>
    </div>
  );
};

export default OwnerDashboard;