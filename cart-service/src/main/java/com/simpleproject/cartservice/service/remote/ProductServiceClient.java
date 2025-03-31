package com.simpleproject.cartservice.service.remote;


import com.simpleproject.cartservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductServiceClient {

    @GetMapping("/sku/{skuCode}")
    ResponseEntity<ProductDto> getProductBySkuCode(@PathVariable("skuCode") String skuCode);

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("id") String id);
}
