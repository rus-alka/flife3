package com.example.demo.repositories;

import com.example.demo.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    @Query("SELECT pl from Plan pl where pl.id = :userId")
    Plan getPlan(@Param("userId") Integer userId);

    Plan findBySessionToken(String sessionToken);

}
