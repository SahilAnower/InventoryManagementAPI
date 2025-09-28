package com.assignment.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDto {
    @NotNull(message = "ProductId cannot be null")
    private Long productId;
    @NotNull(message = "Stock Quantity cannot be null")
    @Min(value = 1, message = "Increment/Decrement Quantity must be at least 1")
    private Integer quantity;
}
