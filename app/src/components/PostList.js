import React, { useEffect, useState } from 'react';

function PostList() {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        // Effectuez une requête fetch pour récupérer la liste des publications depuis votre API Spring Boot
        fetch('/api/posts/')
            .then((response) => response.json())
            .then((data) => setPosts(data));
    }, []);

    return (
        <div>
            <h2>Liste des publications :</h2>
            <ul>
                {posts.map((post) => (
                    <li key={post.id}>{post.description}</li>
                ))}
            </ul>
        </div>
    );
}

export default PostList;
