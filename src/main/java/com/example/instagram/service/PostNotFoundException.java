package com.example.instagram.service;

public class PostNotFoundException extends Throwable {
    public PostNotFoundException(String message) {
        super(message);
    }
}
