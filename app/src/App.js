import './App.css';
import React from 'react';
import UserList from './components/UserList';
import PostList from './components/PostList';
import Header from './components/Header';
import Home from "./pages/home/Home";
import {Route, Routes} from "react-router-dom";
import Login from "./pages/login/Login";

function App() {
    return (
        <div>
            <Login/>
        </div>
    );
}

export default App;
