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
    @GeneratedValue
    private Integer id;

    private String name;

    //private String surname;

    private String gender;

    private Double height;

    private Double weight;

    private String phone_number;

    private String email;

    private String password;

    private Boolean privilege;

    @OneToOne(cascade = CascadeType.MERGE)
    Plan plan;

    @Builder
    public User(String name_us, String email_us, String password_us, Double weight, Double height,
                String phone_number, String gender){
        this.name=name_us;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
        this.phone_number = phone_number;
        this.email=email_us;
    }


}
