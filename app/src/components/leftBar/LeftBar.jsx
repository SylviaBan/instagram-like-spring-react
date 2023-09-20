import React from 'react';
import "./leftBar.css"

import WbSunnyOutlinedIcon from "@mui/icons-material/WbSunnyOutlined";
import StorefrontIcon from "@mui/icons-material/Storefront";
import FavoriteIcon from '@mui/icons-material/Favorite';
import EventIcon from "@mui/icons-material/Event";
import ShortTextIcon from "@mui/icons-material/ShortText";

const LeftBar = () => {
    return (
        <div className="leftBarClass">
            <div className="container">
                <div className="menu>">
                    <div className="icon">
                        <FavoriteIcon/>
                        <span>Amis</span>
                    </div>
                    <div className="icon">
                        <WbSunnyOutlinedIcon/>
                        <span>Endroits</span>
                    </div>
                    <div className="icon">
                        <EventIcon/>
                        <span>Evènements</span>
                    </div>
                    <div className="icon">
                        <StorefrontIcon/>
                        <span>Marketplace</span>
                    </div>
                </div>
            <hr/>
                <div className="menu>">
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                    <div className="icon">
                        <ShortTextIcon/>
                        <span>Raccourci</span>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LeftBar;