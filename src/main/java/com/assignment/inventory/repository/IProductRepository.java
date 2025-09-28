package com.assignment.inventory.repository;

import com.assignment.inventory.model.Product;

import java.util.List;

public interface IProductRepository {
    // crud

    Product create(Product product);
    List<Product> fetchAll();
    Product fetchById(Long id);
    void update(Product product);
    boolean delete(Long id);
}
