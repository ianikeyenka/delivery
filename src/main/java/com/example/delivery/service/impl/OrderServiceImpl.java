package com.example.delivery.service.impl;

import com.example.delivery.dto.OrderDTO;
import com.example.delivery.mapper.OrderMapper;
import com.example.delivery.repository.OrderRepository;
import com.example.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDTO> showOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO showOrder(Long id) {
        return orderMapper.orderToOrderDto(orderRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void createOrUpdateOrder(OrderDTO orderDTO) {
        orderRepository.save(orderMapper.orderDtoToOrder(orderDTO));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
