import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import NavBar from './components/navbar/NavBar'
import UserRegister from './pages/UserRegister'
import OwnerRegister from './pages/OwnerRegister'
import Login from './pages/login/Login'

function App() {
  

  return (
    <BrowserRouter> 
    
      <Routes>
      <Route path="/register" element={<UserRegister />} />
      <Route path="/owner-register" element={<OwnerRegister />} />
      <Route path="login" element={<Login/>}/>
      </Routes>
    
    </BrowserRouter>
  )
}

export default App
