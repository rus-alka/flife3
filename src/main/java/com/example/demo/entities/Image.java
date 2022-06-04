package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String type;

    private byte[] image;
}
