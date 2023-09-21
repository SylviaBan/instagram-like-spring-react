import React, {useEffect, useState} from 'react';

function Comment({ text }) {

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


    return (
        <div className="comments">
            {comments.map((comment) => (
                <div className="comment">
                    <img src={comment.profilePic} alt="" />
                    <div className="info">
                        <span>{comment.username}</span>
                        <p>{comment.text}</p>
                    </div>
                    <span className="date">Il y a 1 heure</span>
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