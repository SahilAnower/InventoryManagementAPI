package com.assignment.inventory.repository;

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

        return productMap.get(product.getId());
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
        return productMap.get(id);
    }

    @Override
    public void update(Product product) {
        if (!productMap.containsKey(product.getId())) {
            throw new ProductNotFoundException("Product not found with id: " + product.getId());
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
