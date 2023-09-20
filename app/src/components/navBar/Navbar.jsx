import React from 'react';
import "./navbar.css"

import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import NotificationsOutlinedIcon from "@mui/icons-material/NotificationsOutlined";
import PersonOutlinedIcon from "@mui/icons-material/PersonOutlined";
import SearchOutlinedIcon from "@mui/icons-material/SearchOutlined";
import {Link} from "react-router-dom";

const Navbar = () => {
    return (
        <div className="navbar">
            <div className="navbarLeft">
                <Link to="/" style={{textDecoration: "none"}}>
                <span className="navbarLeftSpan">NatureConnexion</span>
                </Link>
                <HomeOutlinedIcon/>
                <div className="search">
                    <SearchOutlinedIcon/>
                    <input type={"text"} placeholder={"Rechercher..."}/>
                </div>
            </div>
            <div className="navbarRight">
                <PersonOutlinedIcon/>
                <NotificationsOutlinedIcon/>
                <div className="user">
                    <img src="https://images.pexels.com/photos/6625663/pexels-photo-6625663.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"/>
                    <span>User Name</span>
                </div>
            </div>
        </div>
    );
};

export default Navbar;