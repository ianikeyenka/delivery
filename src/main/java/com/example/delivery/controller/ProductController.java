package com.example.delivery.controller;

import com.example.delivery.model.CustomerModel;
import com.example.delivery.model.ProductModel;
import com.example.delivery.service.CustomerService;
import com.example.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<>(productService.showProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getAllProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.showProduct(id), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel) {
        productService.createProduct(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.CREATED);
    }
}
