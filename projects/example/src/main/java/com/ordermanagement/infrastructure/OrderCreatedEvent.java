package com.ordermanagement.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCreatedEvent {
    private String 주문번호;
    private String 주문상태;
}