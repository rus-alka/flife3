package com.example.demo.services;

import com.example.demo.entities.Exercise;
import com.example.demo.repositories.ExerciseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise save(Exercise exercise) {
        return this.exerciseRepository.save(exercise);
    }

    @Override
    public void deleteById(Integer id) {
        this.exerciseRepository.deleteById(id);
    }

    /*@Override
    public Iterable<Exercise> getAllExercise(Integer userId) {
        return this.exerciseRepository.getAllExercise(userId);
    }
     */
}
