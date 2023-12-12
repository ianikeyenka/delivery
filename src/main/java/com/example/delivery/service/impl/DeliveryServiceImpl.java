package com.example.delivery.service.impl;

import com.example.delivery.model.DeliveryModel;
import com.example.delivery.repository.DeliveryRepository;
import com.example.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public List<DeliveryModel> showDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public DeliveryModel showDelivery(Long id) {
        return deliveryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void createDelivery(DeliveryModel delivery) {
        deliveryRepository.save(delivery);
    }
}
