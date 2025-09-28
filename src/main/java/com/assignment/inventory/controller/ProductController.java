package com.assignment.inventory.controller;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(
                iProductService.createProduct(productDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                iProductService.getProductById(id),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProductDto productDto) {
        iProductService.updateProduct(productDto);

        return new ResponseEntity<>(
            "Product updated successfully with id: " + productDto.getId(),
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(
            iProductService.deleteProductById(id),
            HttpStatus.OK
        );
    }

}
