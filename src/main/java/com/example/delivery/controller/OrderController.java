package com.example.delivery.controller;

import com.example.delivery.model.CustomerModel;
import com.example.delivery.model.OrderModel;
import com.example.delivery.service.CustomerService;
import com.example.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return new ResponseEntity<>(orderService.showOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderModel> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.showOrder(id), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderModel> createCustomer(@RequestBody OrderModel orderModel) {
        orderService.createOrder(orderModel);
        return new ResponseEntity<>(orderModel, HttpStatus.CREATED);
    }
}
