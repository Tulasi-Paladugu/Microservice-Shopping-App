package com.project.microservice.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Product {
	
	@Id
	private String Id;

	private String name;
	
	private String description;
	
	private Long price;
}
