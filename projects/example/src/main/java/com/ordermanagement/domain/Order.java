package com.ordermanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    private String 주문번호;
    private String 주문상태;

    public Order(String 메뉴, String 배송주소) {
        // Generate 주문번호 and set initial 주문상태
        this.주문번호 = generateOrderNumber();
        this.주문상태 = "ORDERED";
        // Additional logic for 메뉴 and 배송주소 can be added here
    }

    private String generateOrderNumber() {
        // This should be replaced with a proper order number generation strategy
        return String.valueOf(System.currentTimeMillis());
    }
}