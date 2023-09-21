import React from 'react';
import "./register.css";
import {Link} from "react-router-dom";

const Register = () => {
    return (
        <div className="register">
            <div className="registerCard">
                <div className="left">
                    <h1>NatureConnect</h1>
                    <p>Chez NatureConnect, nous croyons en la beauté et la puissance de la nature.</p>
                    <p>Que vous soyez un amoureux de la randonnée,
                        un photographe de la nature ou simplement quelqu'un qui apprécie les merveilles de notre planète,
                        vous êtes au bon endroit !</p>
                    <span>Tu as déjà un compte ?</span>
                    <Link to="/login">
                        <button className={"leftButton"}>Connexion</button>
                    </Link>
                </div>
                <div className="right">
                    <h1>Register</h1>
                    <form>
                        <input type="text" placeholder="Username" />
                        <input type="email" placeholder="Email" />
                        <input type="password" placeholder="Password" />
                        <Link to="/">
                            <button className="registerButton">Register</button>
                        </Link>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Register;