import React from 'react';
import "./rightBar.css"

const RightBar = () => {
    return (
        <div className="rightBarClass">
            <div className="container">
                <div className="item">
                    <span>Ils vous ont contacté</span>
                    <div className="user">
                        <div className="userInfo">
                            <img
                                src="https://images.pexels.com/photos/2218786/pexels-photo-2218786.jpeg?auto=compress&cs=tinysrgb&w=600"
                                alt=""
                            />
                            <span>AnneClaire</span>
                        </div>
                        <div className="buttons">
                            <button>Accepter</button>
                            <button>Annuler</button>
                        </div>
                    </div>
                    <div className="user">
                        <div className="userInfo">
                            <img
                                src="https://images.pexels.com/photos/14697557/pexels-photo-14697557.jpeg?auto=compress&cs=tinysrgb&w=600"
                                alt=""
                            />
                            <span>Pierre Legendre</span>
                        </div>
                        <div className="buttons">
                            <button>Accepter</button>
                            <button>Annuler</button>
                        </div>
                    </div>
                </div>
                <div className="user">
                    <div className="userInfo">
                        <img
                            src="https://images.pexels.com/photos/10057618/pexels-photo-10057618.jpeg?auto=compress&cs=tinysrgb&w=600"
                            alt=""
                        />
                        <span>Michaël1975</span>
                    </div>
                    <div className="buttons">
                        <button>Accepter</button>
                        <button>Annuler</button>
                    </div>
                </div>
                <div className="user">
                    <div className="userInfo">
                        <img
                            src="https://images.pexels.com/photos/1727273/pexels-photo-1727273.jpeg?auto=compress&cs=tinysrgb&w=600"
                            alt=""
                        />
                        <span>Anne-Charlotte B.</span>
                    </div>
                    <div className="buttons">
                        <button>Accepter</button>
                        <button>Annuler</button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default RightBar;