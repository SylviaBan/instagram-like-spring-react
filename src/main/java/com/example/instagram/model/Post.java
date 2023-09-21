package com.example.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="post")
@SequenceGenerator(name="post_gen",sequenceName="post_seq", initialValue = 1, allocationSize = 1)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String img;

    // Relation One-to-One vers User id
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post(Long id, String description, String img, User user, List<Comment> comments) {
        this.id = id;
        this.description = description;
        this.img = img;
        this.user = user;
        this.comments = comments;
    }

    public Post(String description, String img, User user) {
        this.description = description;
        this.img = img;
        this.user = user;
    }

    public Post(String description, String img) {
        this.description = description;
        this.img = img;
    }

    public Post(Long id, String description, String img) {
        this.id = id;
        this.description = description;
        this.img = img;
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
