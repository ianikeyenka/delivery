package com.example.delivery.service;

import com.example.delivery.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> showProducts();

    ProductModel showProduct(Long id);

    void createProduct(ProductModel product);
}
