import React, { useEffect, useState } from 'react';

function UserProfile() {
    const [user, setUser] = useState({});
    const [post, setPost] = useState({});
    const [comment, setComment] = useState({});

    useEffect(() => {
        fetch('/api/users/3')
            .then((response) => response.json())
            .then((data) => {
                setUser(data); // Stockez les données de l'utilisateur dans le state
                setPost(data.post); // Stockez les données du post dans le state
            });
    }, []);

    return (
        <div>
            <h2>News de {user.username}</h2>
            <p>Email : {user.email || 'Non défini'}</p>
            <p>Location : {user.location || 'Non définie'}</p>

            {post && (
                <div>
                    <h3>Post</h3>
                    <p>Description : {post.description || 'Non définie'}</p>
                    <img src={post.img} alt="Post"/>
                </div>
            )}
        </div>
    );
}

export default UserProfile;
