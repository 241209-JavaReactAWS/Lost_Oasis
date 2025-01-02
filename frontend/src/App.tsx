import { useState } from 'react'

import './App.css'
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom'
import Login from './components/UserAccount/Login'
import NavBar from './components/navbar/NavBar'
import HotelManagement from './components/HotelOwnerAccount/HotelManagement'
import OwnerDashboard from './components/HotelOwnerAccount/OwnerDashboard'
import OwnerRegister from './components/HotelOwnerAccount/OwnerRegister'
import ReservationsManagement from './components/HotelOwnerAccount/ReservationsManagement'
import HotelDetails from './components/UserAccount/HotelDetails'
import HotelSearch from './components/UserAccount/HotelSearch'
import Register from './components/UserAccount/Register'
import UserBookings from './components/UserAccount/UserBookings'
import AllHotels from './components/hotel-rendering/AllHotels'

function App() {
  

  return (
    <BrowserRouter> 
    
      <NavBar/>
      <Routes>
      <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/hotel-search" element={<HotelSearch />} />

          <Route path="/hotel-details" element={<HotelDetails />} />
          <Route path="/user-bookings" element={<UserBookings />} />
          <Route path="/hotels" element={<AllHotels />} />

          <Route path="/owner-register" element={<OwnerRegister />} />
          <Route path="/owner-dashboard" element={<OwnerDashboard />} />
          <Route path="/hotel-management" element={<HotelManagement />} />
          <Route path="/reservations-management" element={<ReservationsManagement />} />

          <Route path="/" element={<HotelSearch />} />
      </Routes>
    
    </BrowserRouter>
  )
}

export default App
