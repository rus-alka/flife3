package com.example.demo.services;

import com.example.demo.entities.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    //Iterable<User> getAllUsers();
    boolean canRegister(String name, String email);

    Optional<User> findById(Integer id);
}
