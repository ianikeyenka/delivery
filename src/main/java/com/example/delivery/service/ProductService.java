package com.example.delivery.service;

import com.example.delivery.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> showProducts();

    ProductDTO showProduct(Long id);

    void createOrUpdateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}
