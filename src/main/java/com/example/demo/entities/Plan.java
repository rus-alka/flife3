package com.example.demo.entities;

import com.example.demo.repositories.PlanRepository;
import com.example.demo.services.ProductService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue
    private Integer id;

    private Double plusCaloric=0.;
    private Double minusCaloric=0.;

    private Double plusProtein=0.;
    private Double plusFat;
    private Double plusCarbohydrates;


    @Builder
    public Plan(Integer id) {
        this.id = id;
    }

    //@OneToOne//(fetch = FetchType.EAGER, mappedBy = "plan")
    //User user;

    //@OneToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    Set<Exercise> exercises = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    Set<Product> products = new HashSet<>();
    private String sessionToken;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plan)) return false;

        Plan location = (Plan) o;

        return id.equals(location.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
