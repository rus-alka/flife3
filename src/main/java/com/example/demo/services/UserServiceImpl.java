package com.example.demo.services;

import com.example.demo.entities.Plan;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean canRegister(String name, String email) {
        if (!userRepository.findByName(name).isEmpty()) {
            return false;
        }
        if (!userRepository.findByEmail(email).isEmpty()) {
            return false;
        }
        return true;
    }

    public int canLogin(Integer id, String password){
        Integer res=0;
        if (id == 0) return 0;
        Optional<User> userList = userRepository.findById(id);
        ArrayList<User> resList = new ArrayList<>();
        userList.ifPresent(resList::add);
        if (resList.get(0).getPassword().equals(password)){
            if (resList.get(0).getPrivilege())//admin == 1
                res = 2;
            else
                res = 1;
        }
        return res;
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
