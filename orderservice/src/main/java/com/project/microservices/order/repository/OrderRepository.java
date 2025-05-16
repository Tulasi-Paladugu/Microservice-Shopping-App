package com.project.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
