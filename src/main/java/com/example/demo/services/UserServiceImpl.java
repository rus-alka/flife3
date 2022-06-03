package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    //@Override
    //public Iterable<User> getAllUsers() {
    //    return this.userRepository.findAll();
    //}

    /*public boolean canRegister(String name_us, String email_us) {
        if (!userRepository.findByName(name_us).isEmpty()) {
            return false;
        }
        if (!userRepository.findByEmail(email_us).isEmpty()) {
            return false;
        }
        return true;
    }*/
}
