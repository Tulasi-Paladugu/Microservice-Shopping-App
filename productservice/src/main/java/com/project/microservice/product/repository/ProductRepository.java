package com.project.microservice.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.microservice.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
