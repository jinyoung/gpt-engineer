package com.example.fooddeliveryservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    // Constructors, getters, setters, and other methods...
}