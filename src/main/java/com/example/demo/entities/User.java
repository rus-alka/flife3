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

    private String surname;

    private String gender;

    private Double height;

    private Double weight;

    private String phone_number;

    private String email;

    private String password;

    private Boolean privilege;

    //@OneToOne
    //Plan plan;

    @Builder
    public User(String name_us, /*String surname, */ String gender, Double height, Double weight,
                String phone_number, String email_us,  String password_us){
       // this.id=id;
        Plan plan1 = new Plan(this.id);

        this.name=name_us;
        //this.surname=surname;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
        this.phone_number = phone_number;
        this.email=email_us;
        this.password=password_us;
        this.privilege=false;
        //this.plan.setId();
        //this.plan=plan1;
    }


}
