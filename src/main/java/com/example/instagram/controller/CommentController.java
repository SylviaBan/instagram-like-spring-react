package com.example.instagram.controller;

import com.example.instagram.model.Comment;
import com.example.instagram.service.CommentService;
import com.example.instagram.service.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCommentsById(@PathVariable Long id) {
        return commentService.getCommentsById(id);
    }

    @PostMapping("/posts/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) throws PostNotFoundException {
        // Associer le commentaire au post à l'id postId
        return commentService.save(postId, comment);
    }

    @GetMapping("/posts/{postId}")
    public List<Comment> getCommentsForPost(@PathVariable Long postId) {
        return commentService.findByPostId(postId);
    }
}
