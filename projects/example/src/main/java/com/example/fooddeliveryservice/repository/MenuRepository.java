package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // Custom query methods if needed
}