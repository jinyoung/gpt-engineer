package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.inventory.Inventory;
import com.example.orderinventorysystem.domain.inventory.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class InventoryServiceTest {
    @Mock
    private InventoryRepository inventoryRepository;

    private InventoryService inventoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    public void testManageInventory() {
        UUID productId = UUID.randomUUID();
        Integer quantity = 10;
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);

        when(inventoryRepository.findById(productId)).thenReturn(Optional.of(inventory));
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        Inventory managedInventory = inventoryService.manageInventory(productId, quantity);

        assertEquals(productId, managedInventory.getProductId());
        assertEquals(quantity, managedInventory.getQuantity());

        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }
}