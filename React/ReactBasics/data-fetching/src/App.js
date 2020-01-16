import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Link, Router } from '@reach/router';

import HomePage from './views/HomePage';
import Secondary from './views/Secondary';
import Launch from './views/Launches';
import SingleLaunch from './views/SingleLaunch';


function App() {
  return (
    <div>
      <div>
        <Link to="/">HomePage</Link>
        <Link to='/secondary'>Secondary</Link>
        <Link to='/launch'>Launch</Link>
      </div>
      <Router>
        
      </Router>
    </div>
  );
}

export default App;
