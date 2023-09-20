package com.example.instagram.controller;

import com.example.instagram.model.User;
import com.example.instagram.service.UserNotFoundException;
import com.example.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // RETRIEVE ------------------------------
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> usersList = userService.listAll();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    // CREATE ------------------------------
    private List<User> users = new ArrayList<>();
    @GetMapping("/users/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add-form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userService.save(user);
        ra.addFlashAttribute("message", "L'user a bien été ajouté.");
        return "redirect:/users";
    }


    // EDIT ------------------------------
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Mise à jour du user :");
            return "add-form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "L'user a bien été modifié.");
            return "redirect:/users";

        }
    }

    // DELETE ------------------------------
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes ra) {
        userService.delete(id);
        return "redirect:/users";
    }
}
