package com.project.microservices.order.service;

import java.sql.SQLSyntaxErrorException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.microservices.order.client.InventoryClient;
import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.model.Order;
import com.project.microservices.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private InventoryClient inventoryClient;
	
	public Order placeOrder(OrderRequest orderRequest) throws SQLSyntaxErrorException {
		boolean isInStock= inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
		if(isInStock) {
			Order order = Order.builder().orderNumber(UUID.randomUUID().toString())
					.orderValue(orderRequest.orderValue()).skuCode(orderRequest.skuCode()).quantity(orderRequest.quantity()).build();
			Order placedOrder= orderRepository.save(order);
			return placedOrder;
		}else {
			throw new RuntimeException("Product With "+orderRequest.skuCode()+"is not in stock ");
		}
	}
	
}
