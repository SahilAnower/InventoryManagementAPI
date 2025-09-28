package com.assignment.inventory.service;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductDto> getProductsBelowThreshold() {
        List<ProductDto> allProducts = iProductService.getAllProducts();

        return allProducts.stream()
                .filter(p -> p.getStockQuantity() < Product.thresholdQuantity)
                .toList();
    }
}
