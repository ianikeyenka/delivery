package com.example.delivery.service.impl;

import com.example.delivery.dto.ProductDTO;
import com.example.delivery.mapper.ProductMapper;
import com.example.delivery.repository.ProductRepository;
import com.example.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> showProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO showProduct(Long id) {
        return productMapper.productToProductDto(productRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void createOrUpdateProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.productDtoToProduct(productDTO));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
