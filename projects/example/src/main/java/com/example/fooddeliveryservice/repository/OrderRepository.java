package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods if needed
}