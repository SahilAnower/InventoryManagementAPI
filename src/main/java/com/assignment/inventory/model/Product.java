package com.assignment.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer stockQuantity;

    public Product(Product other) {
        if (other == null) {
            throw new IllegalArgumentException("Product to copy cannot be null");
        }
        this.id = other.id;
        this.name = other.name;
        this.description = other.description;
        this.stockQuantity = other.stockQuantity;
    }
}
