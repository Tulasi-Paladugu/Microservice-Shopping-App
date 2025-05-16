package com.project.microservice.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.microservice.product.model.Product;
import com.project.microservice.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController{

	
	private final ProductService productService;
	
	@RequestMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@RequestMapping("/view")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> viewProducts() {
		return productService.viewProducts();
	}
}
