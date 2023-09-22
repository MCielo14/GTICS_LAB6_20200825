package com.example.gtics_lab6_20200825.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "lab6gtics1")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false)
    private Integer id;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;


}