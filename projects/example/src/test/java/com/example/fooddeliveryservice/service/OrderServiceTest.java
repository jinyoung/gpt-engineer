package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void createOrder_ShouldSaveOrder() {
        Order order = new Order();
        // Set order properties...

        orderService.createOrder(order);

        verify(orderRepository).save(order);
    }

    // Other test methods...
}