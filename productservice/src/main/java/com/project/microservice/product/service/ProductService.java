package com.project.microservice.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.microservice.product.model.Product;
import com.project.microservice.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepo;
	
	public Product createProduct(Product product) {
		Product saveProduct = Product.builder().name(product.getName()).description(product.getDescription())
				.price(product.getPrice()).build();
		productRepo.save(saveProduct);
		return saveProduct;
		
	}
	public List<Product> viewProducts(){
		return productRepo.findAll();
		
	}
}
