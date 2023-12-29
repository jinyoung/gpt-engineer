package com.ordermanagement.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponse {
    private String 주문번호;
    private String 주문상태;
}