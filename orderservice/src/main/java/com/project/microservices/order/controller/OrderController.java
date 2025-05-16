package com.project.microservices.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.service.OrderService;
import com.project.microservices.order.model.Order;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Order createOrder(@RequestBody OrderRequest orderRequest) {
		if(orderRequest!=null) {
			return orderService.placeOrder(orderRequest);
		}else {
			return null;
		}
	}
}
