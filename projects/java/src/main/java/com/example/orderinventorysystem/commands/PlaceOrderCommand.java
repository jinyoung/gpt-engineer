package com.example.orderinventorysystem.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderCommand {
    private UUID productId;
    private Integer quantity;
}