package com.example.demo.services;

import com.example.demo.entities.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> getAllProduct();
    void deleteById(Integer id);
}
