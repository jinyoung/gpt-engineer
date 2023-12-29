package com.ordermanagement.application;

import com.ordermanagement.domain.Order;
import com.ordermanagement.domain.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private MessageChannel output;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository, output);
    }

    @Test
    void createOrder_ShouldPublishOrderCreatedEvent() {
        // Arrange
        String 메뉴 = "짬뽕";
        String 배송주소 = "용인시 처인구";
        Order order = new Order(메뉴, 배송주소);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        // Act
        orderService.createOrder(메뉴, 배송주소);

        // Assert
        verify(orderRepository).save(orderCaptor.capture());
        verify(output).send(any(MessageBuilder.class));
        assertEquals("ORDERED", orderCaptor.getValue().get주문상태());
    }
}