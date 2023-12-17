package com.example.delivery.service;

import com.example.delivery.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> showCustomers();

    CustomerDTO showCustomer(Long id);

    void createOrUpdateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long id);
}
