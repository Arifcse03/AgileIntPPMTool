import logo from './logo.svg';
import React from 'react'
import ReactDOM from 'react-dom'
import './App.css';
import Dashboard from './Component/Dashboard';
import Header from './Component/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  return (
    <div className="App">
    <Header/>
      <Dashboard/>
    </div>
  );
}

export default App;
