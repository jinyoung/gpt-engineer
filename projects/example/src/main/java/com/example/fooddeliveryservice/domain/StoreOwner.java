package com.example.fooddeliveryservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store_owners")
public class StoreOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "storeOwner")
    private List<Menu> menus;

    // Constructors, getters, setters, and other methods...
}