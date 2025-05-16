package com.project.microservices.order.dto;

public record OrderRequest( String skuCode, Long orderValue, Integer quantity) {

}
