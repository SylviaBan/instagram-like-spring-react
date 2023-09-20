import React from 'react';
import '../../index.css';
import Posts from "../../components/posts/Posts";
import Users from "../../components/users/Users";
import UserPosts from "../../components/posts/UserPosts";

const Home = () => {
    return (
        <div className="home">
            <UserPosts/>
        </div>
    )
}

export default Home;
