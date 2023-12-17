package com.example.delivery.mapper;

import com.example.delivery.dto.OrderDTO;
import com.example.delivery.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface OrderMapper {
    @Mappings({
            @Mapping(source = "customer.id", target = "customer_id"),
            @Mapping(source = "product.id", target = "product_id")
    })
    OrderDTO orderToOrderDto(OrderModel orderModel);

    @Mappings({
            @Mapping(source = "customer_id", target = "customer.id"),
            @Mapping(source = "product_id", target = "product.id")
    })
    OrderModel orderDtoToOrder(OrderDTO orderDTO);

}
