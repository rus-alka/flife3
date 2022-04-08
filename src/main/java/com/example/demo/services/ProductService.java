package com.example.demo.services;

import com.example.demo.entities.Product;

public interface ProductService {
    Product save(Product product);
    //Iterable<Product> getAllProduct(Integer productId);
    void deleteById(Integer id);
}
