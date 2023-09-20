import React from 'react';
import "./login.css"

const Login = () => {
    return (
        <div className="login">
            <div className="card">
                <div className="left">
                    <h1>Bienvenue sur NatureConnect</h1>
                    <p>Chez NatureConnect, nous croyons en la beauté et la puissance de la nature.</p>
                    <p>Que vous soyez un amoureux de la randonnée,
                        un photographe de la nature ou simplement quelqu'un qui apprécie les merveilles de notre planète,
                        vous êtes au bon endroit !</p>
                    <span>Tu as déjà un compte ?</span>
                    <button>Créer un compte</button>
                </div>
                <div className="right">
                    <h1>Login</h1>
                    <form>
                        <input type="text" placeholder="Username" />
                        <input type="text" placeholder="Password" />
                    <button>Login</button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Login;