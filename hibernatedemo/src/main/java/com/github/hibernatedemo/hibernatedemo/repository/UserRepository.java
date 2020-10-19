package com.github.hibernatedemo.hibernatedemo.repository;

import com.github.hibernatedemo.hibernatedemo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByLocationId(Integer id);
}
