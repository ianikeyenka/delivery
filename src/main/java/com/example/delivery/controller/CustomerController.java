package com.example.delivery.controller;

import com.example.delivery.model.CustomerModel;
import com.example.delivery.service.CustomerService;
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
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        return new ResponseEntity<>(customerService.showCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerModel> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.showCustomer(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel) {
        customerService.createCustomer(customerModel);
        return new ResponseEntity<>(customerModel, HttpStatus.CREATED);
    }
}
