package com.example.demo.services;

import com.example.demo.entities.Plan;
import com.example.demo.repositories.PlanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanRepository plRepository;

    @Override
    public Plan save(Plan card) {
        return this.plRepository.save(card);
    }

    //@Override
    //public Iterable<Plan> getAllPlan(Integer userId) {
        //return this.plRepository.getAllPlan(userId);
    //}

    @Override
    public void deleteById(Integer id) {
        this.plRepository.deleteById(id);
    }

}
