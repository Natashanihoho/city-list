package com.hardziyevich.citylist.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(nullable = false)
    private String name;
    @Setter
    private String imagePath;
}
