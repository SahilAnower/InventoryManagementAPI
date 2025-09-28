package com.assignment.inventory.service;

import com.assignment.inventory.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService{
    private final IProductService iProductService;

    @Autowired
    public InventoryService(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @Override
    public void alterStockQuantity(Long productId, Integer quantity) {
        ProductDto productDto = iProductService.getProductById(productId);

        productDto.setStockQuantity(productDto.getStockQuantity() + quantity);

        iProductService.updateProduct(productDto);
    }
}
