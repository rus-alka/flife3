package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name_us;

    private String gender;

    private Double height;

    private Double weight;

    private String phone_number;

    private String email_us;

    private String password_us;

    @ManyToOne(cascade = CascadeType.MERGE)
    Plan plan;

    @Builder
    public User(String name_us, String email_us, String password_us, Plan plan, Double weight, Double height,
                String phone_number, String gender){
        this.name_us=name_us;
        this.email_us=email_us;
        this.password_us=password_us;
        this.weight=weight;
        this.height=height;
        this.phone_number = phone_number;
        this.gender=gender;
        this.plan=plan;
    }


}
