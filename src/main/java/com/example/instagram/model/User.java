package com.example.instagram.model;

import jakarta.persistence.*;

@Entity
@Table(name="user")
@SequenceGenerator(name="user_gen",sequenceName="user_seq", initialValue = 1, allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String coverPic;
    private String profilePic;
    private String location;

    // Relation One-to-One vers Post
    @OneToOne(mappedBy = "user")
    private Post post;

    public User(Long id, String username, String email, String password, String name, String coverPic, String profilePic, String location, Post post) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.coverPic = coverPic;
        this.profilePic = profilePic;
        this.location = location;
        this.post = post;
    }

    public User(String username, String email, String password, String name, String coverPic, String profilePic, String location, Post post) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.coverPic = coverPic;
        this.profilePic = profilePic;
        this.location = location;
        this.post = post;

    }
    public User(String username, String email, String location, Post post) {
        this.username = username;
        this.email = email;
        this.location = location;
        this.post = post;
    }
    public User(String username, String email, String location) {
        this.username = username;
        this.email = email;
        this.location = location;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Post getPost() {
        return (Post) post;
    }

}
