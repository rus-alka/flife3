package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {
    User save(User user);
    Iterable<User> getAllUsers();
    boolean canRegister(String name, String email);
}
