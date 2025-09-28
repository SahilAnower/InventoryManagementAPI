package com.assignment.inventory.mapper;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.model.Product;

public final class ModelToDtoMapper {
    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setStockQuantity(product.getStockQuantity());

        return productDto;
    }
}
