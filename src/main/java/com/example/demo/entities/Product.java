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

    private Double weight;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    Set<Plan> plan = new HashSet<>();

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
    public Product(Integer id, String name, Double caloric, Double weight) {
        this.id = id;
        this.name = name;
        this.caloric = caloric;
        this.weight = weight;
    }

}
