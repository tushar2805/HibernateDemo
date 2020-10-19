package com.github.hibernatedemo.hibernatedemo.controller;

import com.github.hibernatedemo.hibernatedemo.model.Post;
import com.github.hibernatedemo.hibernatedemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @GetMapping("/posts/user/{id}/posts")
    public List<Post> getPostByUser(@PathVariable Integer id){
        return postService.getPostsByUser(id);
    }
}
