package com.project.microservices.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.microservices.inventory.repository.InventoryRepsoitory;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepsoitory inventoryRepo;
	
	public boolean isInStock(String skuCode, Integer quantity) {
		return inventoryRepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
	}
}
