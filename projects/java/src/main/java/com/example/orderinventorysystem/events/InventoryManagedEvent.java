package com.example.orderinventorysystem.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryManagedEvent {
    private UUID productId;
    private Integer quantity;
}