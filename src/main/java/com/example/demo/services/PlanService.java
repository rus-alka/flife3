package com.example.demo.services;

import com.example.demo.entities.Plan;

public interface PlanService {
    Plan save(Plan plan);
    //Iterable<Plan> getAllPlan(Integer userId);
    void deleteById(Integer id);
    Plan addPlanFirstTime(Integer id, String sessionToken, Double caloric);
    Plan addToExistingPlan(Integer id, String sessionToken, Double caloric);
    Plan getPlanBySessionTokent(String sessionToken);
    Plan removeFromPlan(Integer id, String sessionToken);
    void clearPlan(String sessionToken);
    Plan addPlan(Double caloric);

    Plan getPlan(String planId);
}
