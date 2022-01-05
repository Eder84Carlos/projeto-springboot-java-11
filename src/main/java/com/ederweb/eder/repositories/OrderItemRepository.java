package com.ederweb.eder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederweb.eder.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
