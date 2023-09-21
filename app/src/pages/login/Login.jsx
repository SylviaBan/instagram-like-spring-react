import React from 'react';
import "./login.css"
import {Link} from "react-router-dom";

const Login = () => {
    return (
        <div className="login">
            <div className="loginCard">
                <div className="left">
                    <h1>Bienvenue sur NatureConnect</h1>
                    <p>Chez NatureConnect, nous croyons en la beauté et la puissance de la nature.</p>
                    <p>Que vous soyez un amoureux de la randonnée,
                        un photographe de la nature ou simplement quelqu'un qui apprécie les merveilles de notre planète,
                        vous êtes au bon endroit !</p>
                    <span>Tu n'as pas encore de compte ?</span>
                    <Link to="/register">
                        <button className="leftButton">Créer un compte</button>
                    </Link>
                </div>
                <div className="right">
                    <h1>Login</h1>
                    <form>
                        <input type="text" placeholder="Username" />
                        <input type="password" placeholder="Password" />
                        <Link to="/">
                            <button className="loginButton">Login</button>
                        </Link>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Login;