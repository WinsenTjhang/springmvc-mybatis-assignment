package com.winsen.demo.service;

import com.winsen.demo.model.Product;
import com.winsen.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(String itemId) {
        return productRepository.findById(itemId);
    }

    public List<Product> getLimit(int limit) {
        return productRepository.getLimit(limit);
    }

}
