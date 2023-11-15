package com.app.ms.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.orders.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
