package com.example.delivery.repository;

import com.example.delivery.model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryModel, Long> {
}
