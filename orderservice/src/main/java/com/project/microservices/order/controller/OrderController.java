package com.project.microservices.order.controller;

import java.sql.SQLSyntaxErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.model.Order;
import com.project.microservices.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createOrder(@RequestBody OrderRequest orderRequest) {
		if(orderRequest!=null) {
			String msg="";
			try {
				Order order= orderService.placeOrder(orderRequest);
				if(order!=null) {
					msg= "Order Placed Successfully. Order Id:"+order.getOrderNumber();
				}else {
					msg="Something Went Wrong , Cannot Place Order";
				}
			}catch(SQLSyntaxErrorException e) {
				log.error(e.getMessage());
			}
			return msg;
		}else {
			return null;
		}
	}
}
