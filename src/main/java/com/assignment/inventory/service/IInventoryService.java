package com.assignment.inventory.service;

import com.assignment.inventory.dto.ProductDto;

import java.util.List;

public interface IInventoryService {
    void alterStockQuantity(Long productId, Integer quantity);
    List<ProductDto> getProductsBelowThreshold();
}
