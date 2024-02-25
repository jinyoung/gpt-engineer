package com.example.fooddeliveryservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "riders")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    // Constructors, getters, setters, and other methods...
}