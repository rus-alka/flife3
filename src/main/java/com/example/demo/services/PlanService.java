package com.example.demo.services;

import com.example.demo.entities.Plan;

public interface PlanService {
    Plan save(Plan card);
    //Iterable<Plan> getAllPlan(Integer userId);
    void deleteById(Integer id);
}
