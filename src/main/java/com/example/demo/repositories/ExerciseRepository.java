package com.example.demo.repositories;

import com.example.demo.entities.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    /*@Query("SELECT e from Exercise e where e.plan.id = :planId")
    Iterable<Exercise> getAllExercise(Integer planId);*/

}
