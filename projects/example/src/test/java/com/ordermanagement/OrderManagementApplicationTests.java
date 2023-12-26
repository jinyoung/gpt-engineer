package com.ordermanagement;

import com.ordermanagement.api.OrderController;
import com.ordermanagement.dto.CreateOrderRequest;
import com.ordermanagement.dto.OrderCreatedEvent;
import com.ordermanagement.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderManagementApplicationTests {

    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateOrder() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setMenu("짬뽕");
        request.setDeliveryAddress("용인시 처인구");

        OrderCreatedEvent expectedEvent = new OrderCreatedEvent("1", "ORDERED");
        when(orderService.createOrder(request)).thenReturn(expectedEvent);

        ResponseEntity<OrderCreatedEvent> responseEntity = orderController.createOrder(request);

        assertEquals(201, responseEntity.getStatusCodeValue());
        assertEquals(expectedEvent, responseEntity.getBody());
    }
}