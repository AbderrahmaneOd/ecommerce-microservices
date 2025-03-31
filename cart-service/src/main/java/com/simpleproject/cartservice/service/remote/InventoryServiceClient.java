package com.simpleproject.cartservice.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "invetory-service", url = "${inventory.service.url}")
public interface InventoryServiceClient {

    @GetMapping("/{skuCode}/stock-availability")
    ResponseEntity<Boolean> isStockAvailable(@PathVariable String skuCode, @RequestParam int quantity);
}
