package com.github.hibernatedemo.hibernatedemo.service;

import com.github.hibernatedemo.hibernatedemo.model.User;
import com.github.hibernatedemo.hibernatedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> getUserByLocationId(Integer id){
        return userRepository.findByLocationId(id);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

}

