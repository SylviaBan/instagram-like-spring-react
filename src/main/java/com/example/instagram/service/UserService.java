package com.example.instagram.service;

import com.example.instagram.model.User;
import com.example.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // UPDATE
    public User updateUser(Long id, User user) {
        if (existsById(id)) {

            User existingUser = userRepo.findById(id).orElse(null);

            if (existingUser != null) {
                existingUser.setName(user.getName());
                User updatedUser = userRepo.save(existingUser);
            }
        }
        return null;
    }
    public boolean existsById(Long id) {
        userRepo.existsById(id);
        return false;
    }

    // DELETE
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
    public void deleteAllUser() {
        userRepo.deleteAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Long id) throws UserNotFoundException {
        Optional<User> result = userRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("User with the ID not found" +id);
    }
}
