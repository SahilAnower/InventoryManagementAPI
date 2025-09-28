package com.assignment.inventory.service;

public interface IInventoryService {
    void alterStockQuantity(Long productId, Integer quantity);
}
