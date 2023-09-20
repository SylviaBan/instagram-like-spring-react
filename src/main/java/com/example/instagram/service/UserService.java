package com.example.instagram.service;

import com.example.instagram.model.Post;
import com.example.instagram.model.User;
import com.example.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    // CREATE
    public User addUser(User user) {
        return userRepo.save(new User());
    }

    // FIND
    public List<User> listAll() {;
        return userRepo.findAll();
    }
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Find User par Post
    /*public List<Post> getUserPosts(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPosts();
        } else {
            // Gérez le cas où l'utilisateur n'est pas trouvé
            return Collections.emptyList(); // ou une autre action appropriée
        }
    }*/

    // UPDATE
    public User updateUser(Long id, User user) {
        // Vérifiez d'abord si l'utilisateur existe
        if (!userRepo.existsById(id)) {
            return null; // L'utilisateur n'existe pas
        }
        user.setId(id); // Assurez-vous que l'ID de l'utilisateur est correctement défini
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
