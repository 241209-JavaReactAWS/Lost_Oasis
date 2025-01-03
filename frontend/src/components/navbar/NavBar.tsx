import React from 'react';
import { Link } from 'react-router-dom';
import './NavBar.css'; // Make sure to add custom CSS if needed

const NavBar: React.FC = () => {
  return (
    <div>
      
      <nav className="navbar navbar-expand-lg navbar-dark bg-transparent fixed-top">
        <div className="container-fluid">
          <Link to="/" className="navbar-brand">
            <img
              src="/path/to/logo.png"  // We have to replace this with some logo of small oasis or something
              alt="Hotel Logo"
              className="logo"
            />
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <Link to="/" className="nav-link active">Home</Link>
              </li>
              <li className="nav-item">
              <Link to="/hotels" className="nav-link">Hotels</Link>
             </li>

              <li className="nav-item">
                <Link to="/rooms" className="nav-link">Rooms</Link>
              </li>
              <li className="nav-item">
                <Link to="/book-now" className="nav-link">Book Now</Link>
              </li>
              <li className="nav-item">
                <Link to="/contact" className="nav-link">Contact</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

    </div>
  );
};

export default NavBar;