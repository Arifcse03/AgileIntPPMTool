import React, { Component } from "react";
import "./App.css";
import Dashboard from "./Component/Dashboard";
import Header from "./Component/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import AddProject from "./Component/project/addProject";
import {Provider} from "react-redux";
import store from "./store";
class App extends Component {
  render() {
    return (
      <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          <Routes>
          <Route exact path="/dashboard" element={<Dashboard/>}   />
          <Route exact path="/addProject" element={<AddProject/>}   />
          </Routes>
        </div>
      </Router>
      </Provider>
    );
  }
}

export default App;