import React, { useEffect, useState } from 'react';
import "./allPosts.css"
import FavoriteBorderOutlinedIcon from '@mui/icons-material/FavoriteBorderOutlined';
import FavoriteOutlinedIcon from '@mui/icons-material/FavoriteOutlined';
import TextsmsOutlinedIcon from '@mui/icons-material/TextsmsOutlined';
import ShareOutlinedIcon from '@mui/icons-material/ShareOutlined';
import Comments from "../comments/Comments";

function AllPosts(  ) {
    const [jsonFiles, setJsonFiles] = useState([]);

    const [liked, setLiked] = useState(true);
    const handleLikeClick = () => {
        // Inversion de l'état de 'liked'
        setLiked(!liked);
    };

    const [commentsWrite, setCommentsWrite] = useState(true);

    // Suppression du post
    const handleDeleteClick = async (postId) => {
        // Envoyer une requête de suppression au backend pour supprimer le post
        try {
            const response = await fetch(`/api/posts/${postId}`, {
                method: 'DELETE',
            });

            if (response.ok) {
                // Mettre à jour l'état pour refléter la suppression du post
                setJsonFiles((prevJsonFiles) =>
                    prevJsonFiles.filter((jsonFile) => jsonFile.id !== postId)
                );
            } else {
                console.error('Erreur lors de la suppression du post');
            }
        } catch (error) {
            console.error('Erreur lors de la suppression du post :', error);
        }
    };


    useEffect(() => {
        fetch('/api/users/')
            .then((response) => response.json())
            .then((data) => {
                setJsonFiles(data); // Stockage les données des fichiers JSON dans le state
            });
    }, []);

    return (
        <div className="posts">
            <div className="container">
                {jsonFiles.map((jsonFile) => (
                    <div key={jsonFile.id}>
                        <div className="postContainer">
                            <button className="handle-suppression" onClick={() => handleDeleteClick(jsonFile.id)}>
                                Supprimer
                            </button>
                            <span className="newsUser">News de {jsonFile.username}</span>
                            <div className="user">
                                <div className="userInfo">
                                    <img className="userInfoImg" src={jsonFile.profilePic} alt="profile picture" />
                                    <div className="details">
                                        <span className="email">Email : {jsonFile.email || 'Non défini'}</span>
                                        <span className="date">Localisation : {jsonFile.location || 'Non définie'}</span>
                                    </div>
                                </div>
                            </div>
                            {jsonFile.post && (
                                <div className="content">
                                    <span>{jsonFile.post.description || 'Non définie'}</span>
                                    <img className="postImg" src={jsonFile.post.img} alt="Post" />
                                </div>
                            )}
                            <div className="info">
                                <div className="infoItem" onClick={handleLikeClick}>
                                    {liked ? <FavoriteBorderOutlinedIcon /> : <FavoriteOutlinedIcon />}
                                    {liked ? '11 likes' : '12 likes'}
                                </div>
                                <div className="infoItem" onClick={()=> setCommentsWrite((!commentsWrite))}>
                                    <TextsmsOutlinedIcon />
                                    Commentaires
                                </div>
                                <div className="infoItem">
                                    <ShareOutlinedIcon />
                                    Share
                                </div>
                            </div>
                            {/*si comments true => écrire un commentaire*/}
                            {commentsWrite && <Comments />}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default AllPosts;
