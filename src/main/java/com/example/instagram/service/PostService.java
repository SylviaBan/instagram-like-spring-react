package com.example.instagram.service;

import com.example.instagram.model.Post;
import com.example.instagram.model.User;
import com.example.instagram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    // CREATE
    public Post addPost(Post post) {
        return postRepo.save(new Post());
    }

    // FIND
    public List<Post> findAllPost() {;
        return postRepo.findAll();
    }
    public Optional<Post> findPostById(Long id) {
        return postRepo.findById(id);
    }
    // UPDATE
    public Post updatePost(Long id, Post post) {
        if (existsById(id)) {

            Post existingPost = postRepo.findById(id).orElse(null);

            if (existingPost != null) {
                existingPost.setDescription(post.getDescription());
                Post updatedPost = postRepo.save(existingPost);
            }
        }
        return null;
    }
    public boolean existsById(Long id) {
        postRepo.existsById(id);
        return false;
    }

    // DELETE
    public void delete(Long id) {
        postRepo.deleteById(id);
    }
    public void deleteAllPost() {
        postRepo.deleteAll();
    }

    public Post get(Long id) throws PostNotFoundException {
        Optional<Post> result = postRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PostNotFoundException("Post with the ID not found" +id);
    }

}


