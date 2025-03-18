package com.simpleproject.productservice.controller;


import com.simpleproject.productservice.dto.ProductRequest;
import com.simpleproject.productservice.dto.ProductResponse;
import com.simpleproject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;
    private final PagedResourcesAssembler<ProductResponse> pagedResourcesAssembler;


    // Create Product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        this.productService.createProduct(productRequest);
    }

    // Read All Products
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ProductResponse>>> getAllProducts(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponse> users = productService.getAllProducts(name, pageable);

        // Convert to a stable PagedModel with HATEOAS links
        PagedModel<EntityModel<ProductResponse>> userPagedModel = pagedResourcesAssembler.toModel(users);

        return ResponseEntity.ok(userPagedModel);
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

