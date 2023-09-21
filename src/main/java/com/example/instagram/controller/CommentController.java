package com.example.instagram.controller;

import com.example.instagram.model.Comment;
import com.example.instagram.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/posts/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        // Associer le commentaire au post à l'id postId
        //return commentService.save(comment, postId);
        return null;
    }

    @GetMapping("/posts/{postId}")
    public List<Comment> getCommentsForPost(@PathVariable Long postId) {
        //return commentService.findByPostId(postId);
        return null;
    }
}
