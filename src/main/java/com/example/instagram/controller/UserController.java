package com.example.instagram.controller;
import com.example.instagram.model.Post;
import com.example.instagram.model.User;
import com.example.instagram.service.UserNotFoundException;
import com.example.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*@GetMapping("/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Long userId) throws UserNotFoundException {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return user.get().getPosts();
        } else {
            // Vous pouvez choisir de gérer cette erreur de différentes manières, par exemple en lançant une exception
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }*/

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}