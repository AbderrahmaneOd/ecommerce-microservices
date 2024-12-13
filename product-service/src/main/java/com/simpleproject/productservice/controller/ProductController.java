package com.simpleproject.productservice.controller;


import com.simpleproject.productservice.dto.ProductRequest;
import com.simpleproject.productservice.dto.ProductResponse;
import com.simpleproject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Create Product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        this.productService.createProduct(productRequest);
    }

    // Read All Products
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }

    // Read a Single Product by ID
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable String id) {
        return this.productService.getProductById(id);
    }

    // Update Product
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest) {
        this.productService.updateProduct(id, productRequest);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) {
        this.productService.deleteProduct(id);
    }

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

}

