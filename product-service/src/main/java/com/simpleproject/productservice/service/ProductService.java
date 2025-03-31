package com.simpleproject.productservice.service;


import com.simpleproject.productservice.dto.ProductRequest;
import com.simpleproject.productservice.dto.ProductResponse;
import com.simpleproject.productservice.exception.ProductNotFoundException;
import com.simpleproject.productservice.model.Product;
import com.simpleproject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    // Create Product
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .skuCode(generateSku(productRequest.getName()))
                .build();
        productRepository.save(product);
        log.info("Product {} is saved successfully", product.getId());
    }

    // SKU Generation Strategy
    private String generateSku(String productName) {
        String prefix = productName.replaceAll("[^A-Za-z0-9]", "").substring(0, Math.min(4, productName.length())).toUpperCase();
        String uniqueId = UUID.randomUUID().toString().substring(0, 8).toUpperCase(); // Shortened UUID
        return prefix + "-" + uniqueId; // Example: "LAPT-1A2B3C4D"
    }

    // Get All Products
    public Page<ProductResponse> getAllProducts(String name, Pageable pageable) {
        Page<Product> products = productRepository.findByNameLike(name, pageable);

        return products.map(product -> new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSkuCode()
                ));
    }

    // Get Product By ID
    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return mapToProductResponse(product);
    }

    // Update Product
    public void updateProduct(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        log.info("Product {} is updated successfully", id);
    }

    // Delete Product
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
        log.info("Product {} is deleted successfully", id);
    }

    // Map Product to ProductResponse
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .skuCode(product.getSkuCode())
                .build();
    }

    public ProductResponse getProductBySkuCode(String skuCode) {
        Product product = productRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + skuCode));
        return mapToProductResponse(product);
    }
}


