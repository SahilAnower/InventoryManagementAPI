package com.assignment.inventory.service;

import com.assignment.inventory.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    void updateProduct(ProductDto productDto);
    String deleteProductById(Long id);
}
