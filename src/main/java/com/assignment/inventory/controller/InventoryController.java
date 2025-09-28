package com.assignment.inventory.controller;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.dto.ProductStockDto;
import com.assignment.inventory.service.IInventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/inventories", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {
    private final IInventoryService inventoryService;

    @Autowired
    public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/increment")
    public ResponseEntity<String> incrementStock(@Valid @RequestBody ProductStockDto productStockDto) {
        inventoryService.alterStockQuantity(productStockDto.getProductId(), productStockDto.getQuantity());

        return new ResponseEntity<>(
                "Product quantity increased successfully",
                HttpStatus.OK
        );
    }

    @PostMapping("/decrement")
    public ResponseEntity<String> decrementStock(@Valid @RequestBody ProductStockDto productStockDto) {
        inventoryService.alterStockQuantity(productStockDto.getProductId(), -productStockDto.getQuantity());

        return new ResponseEntity<>(
                "Product quantity decreased successfully",
                HttpStatus.OK
        );
    }

    @GetMapping("/threshold-products")
    public ResponseEntity<List<ProductDto>> getAllBelowThresholdProducts() {
        return new ResponseEntity<>(
                inventoryService.getProductsBelowThreshold(),
                HttpStatus.OK
        );
    }
}
