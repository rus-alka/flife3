package com.example.demo.services;

import com.example.demo.entities.Exercise;

public interface ExerciseService {
    Exercise save(Exercise exercise);
    //Iterable<Exercise> getAllExercise(Integer planId);
    void deleteById(Integer id);
}
