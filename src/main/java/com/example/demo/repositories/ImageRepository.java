package com.example.demo.repositories;

import com.example.demo.entities.Image;
import com.example.demo.entities.Plan;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
