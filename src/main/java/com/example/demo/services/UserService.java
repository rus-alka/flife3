package com.example.demo.services;

import com.example.demo.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(User user);
    //Iterable<User> getAllUsers();
    //boolean canRegister(String name_us, String email_us);
}
