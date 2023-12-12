package com.example.delivery.service.impl;

import com.example.delivery.model.OrderModel;
import com.example.delivery.repository.OrderRepository;
import com.example.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderModel> showOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel showOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void createOrder(OrderModel order) {
        orderRepository.save(order);
    }
}
