package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    /*public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }*/
    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        this.productRepository.deleteById(id);
    }
}
