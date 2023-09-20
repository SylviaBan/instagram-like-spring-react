import React, { useEffect, useState } from 'react';
import "./allPosts.css"

function AllPosts() {
    const [jsonFiles, setJsonFiles] = useState([]);

    useEffect(() => {
        fetch('/api/users/')
            .then((response) => response.json())
            .then((data) => {
                setJsonFiles(data); // Stockage les données des fichiers JSON dans le state
            });
    }, []);

    return (
        <div className="posts">
            {jsonFiles.map((jsonFile) => (
                <div key={jsonFile.id}>
                    <h3>News de {jsonFile.username}</h3>
            <div className="user">
                <div className="userInfo">
                    <img src={jsonFile.profilePic} alt="profile picture"/>
                    <div className="details">
                        <p>Email : {jsonFile.email || 'Non défini'}</p>
                        <p>Localisation : {jsonFile.location || 'Non définie'}</p>
                    </div>
                </div>
            </div>
            <div className="content"></div>
            <div className="info"></div>

                    {jsonFile.post && (
                        <div>
                            <h4>Post</h4>
                            <p>Description : {jsonFile.post.description || 'Non définie'}</p>
                            <img src={jsonFile.post.img} alt="Post" />
                        </div>
                    )}
                </div>
            ))}
        </div>
    );
}

export default AllPosts;
