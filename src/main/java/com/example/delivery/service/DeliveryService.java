package com.example.delivery.service;

import com.example.delivery.model.DeliveryModel;

import java.util.List;

public interface DeliveryService {
    List<DeliveryModel> showDeliveries();

    DeliveryModel showDelivery(Long id);

    void createDelivery(DeliveryModel delivery);
}
