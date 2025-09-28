package com.assignment.inventory.repository;

import com.assignment.inventory.exception.InvalidProductException;
import com.assignment.inventory.exception.InvalidStockOperationException;
import com.assignment.inventory.exception.ProductNotFoundException;
import com.assignment.inventory.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("productRepository1")
public class ProductRepository implements IProductRepository{

    private final Map<Long, Product> productMap;
    private static Long counterId = 0L;

    public ProductRepository() {
        this.productMap = new HashMap<>();
    }

    @Override
    public Product create(Product product) {
        product.setId(counterId++);
        productMap.put(product.getId(), product);

        return new Product(productMap.get(product.getId()));
    }

    @Override
    public List<Product> fetchAll() {
        return List.copyOf(productMap.values());
    }

    @Override
    public Product fetchById(Long id) {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return new Product(productMap.get(id));
    }

    @Override
    public void update(Product product) {
        if (product.getId() == null) {
            throw new InvalidProductException("Product id cannot be null");
        }

        if (!productMap.containsKey(product.getId())) {
            throw new ProductNotFoundException("Product not found with id: " + product.getId());
        }

        if (product.getStockQuantity() != null && product.getStockQuantity() < 0) {
            throw new InvalidStockOperationException("Product " + product.getId() + " cannot be updated with -ve stock value: " + Math.abs(product.getStockQuantity()));
        }

        Product foundProduct = productMap.get(product.getId());

        if (product.getName() != null) {
            foundProduct.setName(product.getName());
        }
        if (product.getDescription() != null) {
            foundProduct.setDescription(product.getDescription());
        }
        if (product.getStockQuantity() != null) {
            foundProduct.setStockQuantity(product.getStockQuantity());
        }
    }

    @Override
    public boolean delete(Long id) {
        if (!productMap.containsKey(id)) {
            return false;
        }

        productMap.remove(id);

        return true;
    }
}
