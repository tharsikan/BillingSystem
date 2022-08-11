package com.xyzstore.billingservice.repository;

import com.xyzstore.billingservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
