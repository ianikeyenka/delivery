package com.example.delivery.service.impl;

import com.example.delivery.model.ProductModel;
import com.example.delivery.repository.ProductRepository;
import com.example.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductModel> showProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel showProduct(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void createProduct(ProductModel product) {
        productRepository.save(product);
    }
}
