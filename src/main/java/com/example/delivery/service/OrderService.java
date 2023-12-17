package com.example.delivery.service;

import com.example.delivery.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> showOrders();

    OrderDTO showOrder(Long id);

    void createOrUpdateOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);
}
