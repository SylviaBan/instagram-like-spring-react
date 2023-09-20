import './App.css';
import React from 'react';
import UserList from './components/UserList';
import PostList from './components/PostList';

function App() {
  return (
      <div>
        <h1>Mon Application React</h1>
        <UserList />
        <PostList />
      </div>
  );
}

export default App;
