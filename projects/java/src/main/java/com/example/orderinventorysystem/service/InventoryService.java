package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.commands.ManageInventoryCommand;
import com.example.orderinventorysystem.domain.Inventory;
import com.example.orderinventorysystem.events.InventoryManagedEvent;
import com.example.orderinventorysystem.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public InventoryManagedEvent manageInventory(ManageInventoryCommand command) {
        // Business logic to manage inventory
        Inventory inventory = inventoryRepository.findById(command.getProductId()).orElse(new Inventory());
        inventory.setProductId(command.getProductId());
        inventory.setQuantity(command.getQuantity());
        inventory = inventoryRepository.save(inventory);

        return new InventoryManagedEvent(inventory.getProductId(), inventory.getQuantity());
    }
}