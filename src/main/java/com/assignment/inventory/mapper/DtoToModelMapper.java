package com.assignment.inventory.mapper;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.model.Product;

public final class DtoToModelMapper {
    public static Product toProduct(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getStockQuantity());
    }
}
