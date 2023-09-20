import React from 'react';
import '../../index.css';
import UserPosts from "../../components/posts/UserPosts";
import AllPosts from "../../components/posts/AllPosts";

const Home = () => {
    return (
        <div className="home">
            <AllPosts/>
        </div>
    )
}

export default Home;
