package com.ederweb.eder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederweb.eder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

		
	}

