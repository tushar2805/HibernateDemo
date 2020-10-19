package com.github.hibernatedemo.hibernatedemo.controller;

import com.github.hibernatedemo.hibernatedemo.model.Post;
import com.github.hibernatedemo.hibernatedemo.model.User;
import com.github.hibernatedemo.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/{id}/posts")
    public List<Post> getPostByUser(@PathVariable Integer id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()){
            return user.get().getPosts();
        }
        return null;
    }

    @GetMapping("/users/location/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Integer id){
        return userService.getUserByLocationId(id);
    }

    @DeleteMapping("/user/{id}/delete")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
