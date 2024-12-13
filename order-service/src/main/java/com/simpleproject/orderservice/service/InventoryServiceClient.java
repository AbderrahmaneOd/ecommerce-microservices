package com.simpleproject.orderservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceClient {

    private final WebClient.Builder webClientBuilder;

    // Inject inventory service URL from properties
    @Value("${inventory.service.url}")
    private String inventoryServiceUrl;

    // Define resilience4j annotations for retry, circuit breaker, and timeout
    @Retry(name = "inventoryRetry")
    @CircuitBreaker(name = "inventoryCircuitBreaker", fallbackMethod = "fallbackCheckInventory")
    //@TimeLimiter(name = "inventoryTimeLimiter")
    public boolean checkInventory(String skuCode, int quantity) {
        // String inventoryServiceUrl = "http://localhost:8080"; // Base URL

        // Call inventory service
        Boolean isInStock = webClientBuilder
                .baseUrl(inventoryServiceUrl) // Set the base URL here
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/inventories/{skuCode}/availability") // skuCode as a path variable
                        .queryParam("quantity", quantity) // quantity as a query parameter
                        .build(skuCode)) // Set skuCode value in the URI
                .retrieve()
                .bodyToMono(Boolean.class) // Expecting a Boolean response
                .block(); // Blocking

        log.info("Inventory check for SKU {}: {}", skuCode, isInStock);
        return isInStock != null && isInStock;
    }

    // Fallback method in case of failures
    public boolean fallbackCheckInventory(String skuCode, int quantity, Throwable t) {
        log.error("Failed to check inventory for SKU {}: {}", skuCode, t.getMessage());
        System.out.println("Inventory Service experiences temporary failures or timeouts : " + t.getMessage());
        return false;
    }
}

