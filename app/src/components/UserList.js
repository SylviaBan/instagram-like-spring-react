import React, { useEffect, useState } from 'react';

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // Effectuez une requête fetch pour récupérer la liste des utilisateurs depuis votre API Spring Boot
    fetch('/api/users/')
      .then((response) => response.json())
      .then((data) => setUsers(data));
  }, []);

  return (
    <div>
      <h2>Liste des utilisateurs :</h2>
      <ul>
        {users.map((user) => (
          <li key={user.id}>{user.email}</li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;
