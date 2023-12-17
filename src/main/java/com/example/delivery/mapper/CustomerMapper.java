package com.example.delivery.mapper;

import com.example.delivery.dto.CustomerDTO;
import com.example.delivery.model.CustomerModel;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO customerToCustomerDto(CustomerModel customerModel);

    CustomerModel customerDtoToCustomer(CustomerDTO customerDTO);
}
