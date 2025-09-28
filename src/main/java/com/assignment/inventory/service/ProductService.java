package com.assignment.inventory.service;

import com.assignment.inventory.dto.ProductDto;
import com.assignment.inventory.exception.InvalidProductException;
import com.assignment.inventory.mapper.DtoToModelMapper;
import com.assignment.inventory.mapper.ModelToDtoMapper;
import com.assignment.inventory.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private final IProductRepository iProductRepository;

    @Autowired
    public ProductService(@Qualifier("productRepository") IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return ModelToDtoMapper.toProductDto(
                iProductRepository.create(DtoToModelMapper.toProduct(productDto)));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return iProductRepository.fetchAll().stream().map(ModelToDtoMapper::toProductDto).toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return ModelToDtoMapper.toProductDto(iProductRepository.fetchById(id));
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        iProductRepository.update(DtoToModelMapper.toProduct(productDto));
    }

    @Override
    public String deleteProductById(Long id) {
        boolean isDeleteSuccessful = iProductRepository.delete(id);
        return isDeleteSuccessful ? "Product Deleted Successfully" : "Product Cannot be deleted";
    }
}
