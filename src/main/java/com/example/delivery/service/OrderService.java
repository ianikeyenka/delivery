package com.example.delivery.service;

import com.example.delivery.model.OrderModel;

import java.util.List;

public interface OrderService {
    List<OrderModel> showOrders();

    OrderModel showOrder(Long id);

    void createOrder(OrderModel order);
}
