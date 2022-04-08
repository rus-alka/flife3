package com.example.demo.repositories;

import com.example.demo.entities.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
    //@Query("SELECT pl from Plan pl where pl.user.id = :userId")
    //Iterable<Plan> getAllPlan(Integer userId);

}
