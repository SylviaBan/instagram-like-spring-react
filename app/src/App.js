import './App.css';
import React from 'react';
import {Outlet, Route, Routes} from "react-router-dom";
import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import Register from "./pages/register/Register";
import LeftBar from "./components/leftBar/LeftBar";
import RightBar from "./components/rightBar/RightBar";
import Navbar from "./components/navBar/Navbar";
import Profile from "./pages/profile/Profile";

function App() {


    const Layout = () => {
        return (
            <div>
                <Navbar />
                <div style={{display: "flex"}}>
                    <LeftBar/>
                    <div style={{ flex:6 }}>
                        <Outlet />
                    </div>
                    <RightBar/>
                </div>
            </div>
        )
    }

    return (
        <div>
            <Routes>
                <Route path ="/" element={<Layout/>}>
                    {/* Chemin enfant pour le Home */}
                    <Route index element={<Home />} />
                    {/* Chemin enfant pour le profil */}
                    <Route path="/profile/:id" element={<Profile />} />
                </Route>
                <Route path ="/login" element={<Login/>}/>
                <Route path ="/register" element={<Register/>}/>
            </Routes>
        </div>
    );
}

export default App;
