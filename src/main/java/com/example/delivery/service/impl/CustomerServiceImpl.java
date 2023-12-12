package com.example.delivery.service.impl;

import com.example.delivery.model.CustomerModel;
import com.example.delivery.repository.CustomerRepository;
import com.example.delivery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerModel> showCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel showCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void createCustomer(CustomerModel customer) {
        customerRepository.save(customer);
    }
}
