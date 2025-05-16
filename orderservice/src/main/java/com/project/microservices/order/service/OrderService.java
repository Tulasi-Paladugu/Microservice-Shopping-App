package com.project.microservices.order.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.model.Order;
import com.project.microservices.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order placeOrder(OrderRequest orderRequest) {
		Order order = Order.builder().orderNumber(UUID.randomUUID().toString())
				.orderValue(orderRequest.orderValue()).skuCode(orderRequest.skuCode()).quantity(orderRequest.quantity()).build();
		Order placedOrder= orderRepository.save(order);
		return placedOrder;
	}
	
}
