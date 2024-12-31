import React, { useState } from 'react';

const OwnerRegister = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [businessDetails, setBusinessDetails] = useState('');

  return (
    <div className="form-container">
      <h2>Register as Hotel Owner</h2>
      <form>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <input
          type="text"
          placeholder="Business Details"
          value={businessDetails}
          onChange={(e) => setBusinessDetails(e.target.value)}
        />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default OwnerRegister;