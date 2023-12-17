package com.example.delivery.service.impl;

import com.example.delivery.dto.CustomerDTO;
import com.example.delivery.mapper.CustomerMapper;
import com.example.delivery.repository.CustomerRepository;
import com.example.delivery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> showCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO showCustomer(Long id) {
        return customerMapper.customerToCustomerDto(customerRepository
                .findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void createOrUpdateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerMapper.customerDtoToCustomer(customerDTO));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
