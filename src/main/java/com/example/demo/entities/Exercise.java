package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Double energy_consumption;

    private Integer duration;

    @Builder
    public Exercise(Integer id, String name, Double energy_consumption, Integer duration) {
        this.id = id;
        this.name = name;
        this.energy_consumption = energy_consumption;
        this.duration = duration;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "exercises")
    Set<Plan> plan = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise exercise)) return false;

        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
