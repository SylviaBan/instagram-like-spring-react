package com.example.instagram.controller;

import com.example.instagram.model.Post;
import com.example.instagram.service.PostService;
import com.example.instagram.service.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/home")
public class PostController {
    
    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // RETRIEVE ------------------------------
    @GetMapping("/posts")
    public String listPosts(Model model) {
        List<Post> postsList = postService.findAllPost();
        model.addAttribute("postsList", postsList);
        return "posts";
    }

    // CREATE ------------------------------v
    private List<Post> posts = new ArrayList<>();
    @GetMapping("/posts/add")
    public String showAddForm(Model model) {
        model.addAttribute("post", new Post());
        return "add-form";
    }
    @PostMapping("/posts/save")
    public String savePost(Post post, RedirectAttributes ra) {
        postService.addPost(post);
        ra.addFlashAttribute("message", "Le post a bien été ajouté.");
        return "redirect:/posts";
    }


    // EDIT ------------------------------
    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Post post = postService.get(id);
            model.addAttribute("post", post);
            model.addAttribute("pageTitle", "Mise à jour du post :");
            return "add-form";
        } catch (PostNotFoundException e) {
            ra.addFlashAttribute("message", "Le post a bien été modifié.");
            return "redirect:/posts";

        }
    }

    // DELETE ------------------------------
    @GetMapping("/posts/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
