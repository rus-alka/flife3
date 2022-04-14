package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    //@Query("SELECT pr from Product pr where pr.plan.id = :planId")
    //Iterable<Product> getAllProduct(Integer planId);

}
