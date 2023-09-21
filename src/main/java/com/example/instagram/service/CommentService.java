package com.example.instagram.service;

import com.example.instagram.model.Comment;
import com.example.instagram.model.Post;
import com.example.instagram.repository.CommentRepository;
import com.example.instagram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    // Méthodes
    public Comment save(Long postId, Comment comment) throws PostNotFoundException {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            comment.setPost(post.get());
            return commentRepository.save(comment);
        } else {
            // Le cas où le post avec l'ID spécifié n'existe pas
            throw new PostNotFoundException("Post not found with ID: " + postId);
        }
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentsById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

}
