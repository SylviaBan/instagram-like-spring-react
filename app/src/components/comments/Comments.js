import React, {useContext, useEffect, useState} from 'react';
import "./comments.css"

function Comment({ text }) {

    // Current User
    const [currentUser, setCurrentUser] = useState({
        id: 5,
        username: 'user123',
        profilePic: 'https://images.pexels.com/photos/609549/pexels-photo-609549.jpeg?auto=compress&cs=tinysrgb&w=600',
    });

    //Commentaires en dur
    const comments = [
        {
            id: 1,
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Autem nequeaspernatur ullam aperiam. Lorem ipsum dolor sit amet consectetur adipisicing elit. Autem nequeaspernatur ullam aperiam",
            username: "Cécile Lechevallier",
            userId: 1,
            profilePic:
                "https://images.pexels.com/photos/733872/pexels-photo-733872.jpeg?auto=compress&cs=tinysrgb&w=600",
        },
        {
            id: 2,
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Autem nequeaspernatur ullam aperiam",
            username: "Mathilde Meunier",
            userId: 2,
            profilePic:
                "https://images.pexels.com/photos/1130626/pexels-photo-1130626.jpeg?auto=compress&cs=tinysrgb&w=600",
        },
    ];

    const handleCommentSubmit = async (event) => {
        event.preventDefault();
        // Récupération du contenu du commentaire depuis l'input
        const commentContent = event.target.commentContent.value;

        // Objet de commentaire à envoyer à l'API
        const newComment = {
            content: commentContent,
            userId: currentUser.id,
        };

        // Envoi de commentaire à l'API via une requête POST
        try {
            const response = await fetch('/api/comments/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(newComment),
            });

            if (response.ok) {
                // Le commentaire a été soumis avec succès, réinitialisation du formulaire
                event.target.reset();
            } else {
                console.error('Erreur lors de la soumission du commentaire');
            }
        } catch (error) {
            console.error('Erreur lors de la soumission du commentaire :', error);
        }
    };



    return (
        <div className="comments-all">
            <div className="comment-write">
                <img className="comment-img" src={currentUser.profilePic} alt={currentUser.username} />
                <form onSubmit={handleCommentSubmit} className="comment-form">
                    <input type="text" id="commentContent" className="comment-input" placeholder="Rédigez votre commentaire" />
                    <button type="submit" className="submit-button">Publier</button>
                </form>
            </div>
            {comments.map((comment) => (
                <div className="comment-item">
                    <img class="comment-img" src={comment.profilePic} alt="" />
                    <div className="comment-info">
                        <span className="comment-span">{comment.username}</span>
                        <p className="comment-p">{comment.text}</p>
                    </div>
                    <span className="comment-date">Il y a 1 heure</span>
                </div>
            ))}
        </div>
    );
}

export default Comment;


{/*const [jsonFiles, setJsonFiles] = useState([]);

useEffect(() => {
    fetch('/api/users/')
        .then((response) => response.json())
        .then((data) => {
            setJsonFiles(data);
        });
}, []);



return (
  <div className="comments">
        comments.map(comment=> (
        <div className="comment">
            {jsonFiles.map((jsonFile) => (
            <img className="userInfoImg" src={jsonFile.profilePic} alt="profile picture" />
                        ))};
            <div className="commentInfo">
                <span>{jsonFile.comment.name}</span>
                <p>{jsonFile.comment.descr}</p>
                <span>Il y a 1 heure</span>
            </div>
        </div>
        )
    </div>
);

export default Comments;*/}