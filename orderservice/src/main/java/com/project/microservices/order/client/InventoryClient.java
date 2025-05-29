package com.project.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value="inventory", url="http://localhost:8082")
public interface InventoryClient {

	@GetMapping("/api/inventory")
	public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
