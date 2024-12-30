import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
  return (
    <nav className="navbar">
       <Link to="/"> Home</Link>
      <Link to="/register"> Register</Link>
      <Link to="/login"> Login</Link>
      <Link to="/hotel-search"> Hotel Search</Link>
      <Link to="/hotel-details"> Hotel details</Link>
      <Link to="/user-bookings"> My Bookings</Link>
      <Link to="/reservations-management"> Reservation management</Link>
      <Link to="/owner-register"> Register as Owner</Link>
      <Link to="/owner-dashboard"> Owner Dashboard</Link>
      <Link to="/hotel-management"> Hotel management</Link>

    </nav>
  );
};

export default NavBar;