package com.example.delivery.service;

import com.example.delivery.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> showCustomers();

    CustomerModel showCustomer(Long id);

    void createCustomer(CustomerModel customer);
}
