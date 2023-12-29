package com.example.orderinventorysystem.controller;

import com.example.orderinventorysystem.commands.ManageInventoryCommand;
import com.example.orderinventorysystem.events.InventoryManagedEvent;
import com.example.orderinventorysystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/manage")
    public ResponseEntity<InventoryManagedEvent> manageInventory(@RequestBody ManageInventoryCommand command) {
        InventoryManagedEvent event = inventoryService.manageInventory(command);
        return ResponseEntity.ok(event);
    }
}