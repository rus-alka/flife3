package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }
    /*@Override
    public Iterable<Product> getAllProduct(Integer planId) {
        return this.productRepository.getAllProduct(planId);
    }*/
    @Override
    public void deleteById(Integer id) {
        this.productRepository.deleteById(id);
    }
}
