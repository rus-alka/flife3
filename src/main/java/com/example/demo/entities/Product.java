package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Double caloric;
    private Double protein;
    private Double fat;
    private Double carbohydrates;

    private Double weight;

    private String image_product;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    Set<Plan> plan = new HashSet<>();
    private String sessionToken;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Builder
    public Product(String name, Double caloric, Double protein, Double fat, Double carbohydrates) {
        this.name = name;
        this.caloric = caloric;
        this.protein= protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

}
