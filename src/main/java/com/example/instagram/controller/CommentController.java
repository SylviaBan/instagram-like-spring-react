package com.example.instagram.controller;

import com.example.instagram.model.Comment;
import com.example.instagram.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/post/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        // Associer le commentaire au post à l'id postID
        return commentRepository.save(comment);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsForPost(@PathVariable Long postId) {
        return commentRepository.findByPostId(postId);
    }
}

