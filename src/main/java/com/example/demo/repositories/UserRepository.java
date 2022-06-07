package com.example.demo.repositories;

import com.example.demo.entities.Exercise;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);
    //@Query("SELECT u from Users u where u.user.email = :email")
    Optional<User> findByEmail(String email);
    Optional<User> findById(Integer id);
    //@Query("SELECT u from Users u where u.user.id = :userId")
    //Iterable<Exercise> getAllUsers(Integer userId);

}
