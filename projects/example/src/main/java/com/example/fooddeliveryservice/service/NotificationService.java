package com.example.fooddeliveryservice.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendOrderStatusUpdate(Long orderId, OrderStatus status) {
        // Implement notification sending logic (e.g., via KakaoTalk API)
    }
}