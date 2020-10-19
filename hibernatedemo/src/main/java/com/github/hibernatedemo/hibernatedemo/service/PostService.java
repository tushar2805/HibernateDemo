package com.github.hibernatedemo.hibernatedemo.service;

import com.github.hibernatedemo.hibernatedemo.model.Post;
import com.github.hibernatedemo.hibernatedemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByUser(Integer id){
        return postRepository.findByUserId(id);
    }
}
