package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.order.Order;
import com.example.orderinventorysystem.domain.order.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void testPlaceOrder() {
        UUID productId = UUID.randomUUID();
        Integer quantity = 10;
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("PLACED");
        order.setStatusType(Order.StatusType.PLACED);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order placedOrder = orderService.placeOrder(productId, quantity);

        assertEquals(productId, placedOrder.getProductId());
        assertEquals(quantity, placedOrder.getQuantity());
        assertEquals("PLACED", placedOrder.getStatus());
        assertEquals(Order.StatusType.PLACED, placedOrder.getStatusType());

        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // Additional tests for processOrder and updateDeliveryStatus would follow a similar pattern
}