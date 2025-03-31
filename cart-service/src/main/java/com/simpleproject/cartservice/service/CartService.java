package com.simpleproject.cartservice.service;

import com.simpleproject.cartservice.dto.AddToCartRequest;
import com.simpleproject.cartservice.dto.ProductDto;
import com.simpleproject.cartservice.dto.UserDto;
import com.simpleproject.cartservice.exception.InsufficientInventoryException;
import com.simpleproject.cartservice.exception.ProductNotFoundException;
import com.simpleproject.cartservice.exception.UserNotFoundException;
import com.simpleproject.cartservice.model.CartItem;
import com.simpleproject.cartservice.repository.CartRepository;
import com.simpleproject.cartservice.service.remote.InventoryServiceClient;
import com.simpleproject.cartservice.service.remote.ProductServiceClient;
import com.simpleproject.cartservice.service.remote.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    @Qualifier("com.simpleproject.cartservice.service.remote.UserServiceClient")
    private final UserServiceClient userService;
    private final ProductServiceClient productService;
    private final InventoryServiceClient inventoryService;

    public CartService(
            CartRepository cartRepository,
            @Qualifier("com.simpleproject.cartservice.service.remote.UserServiceClient") UserServiceClient userService,
            ProductServiceClient productService,
            InventoryServiceClient inventoryService
    ){
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;
        this.inventoryService = inventoryService;
    }

    public void addItemToCart(String userId, AddToCartRequest item) {
        // Check if user exists
        if(!userId.startsWith("guest-")){ //Handling guest users
            ResponseEntity<UserDto> userResponse = userService.getUserById(userId);
            if (!userResponse.getStatusCode().is2xxSuccessful()) {
                throw new UserNotFoundException("User not found: " + userId);
            }
        }

        // Check if product exists by ID
        ResponseEntity<ProductDto> productResponse = productService.getProductById(item.getProductId());
        if (!productResponse.getStatusCode().is2xxSuccessful()) {
            throw new ProductNotFoundException("Product not found with ID: " + item.getProductId());
        }

        ProductDto product = productResponse.getBody();

        // Check if inventory is available
        ResponseEntity<Boolean> inventoryResponse =
                inventoryService.isStockAvailable(product.getSkuCode(), item.getQuantity());
        if (!inventoryResponse.getStatusCode().is2xxSuccessful() ||
                !Boolean.TRUE.equals(inventoryResponse.getBody())) {
            throw new InsufficientInventoryException("Not enough inventory for ID: " + item.getProductId());
        }

        // Add to cart in Redis
        cartRepository.addToCart(userId, item);
    }

    public List<Object> getCart(String userId) {
        return cartRepository.getCart(userId);
    }

    public void removeCartItem(String userId, CartItem item) {
        cartRepository.removeCartItem(userId, item);
    }

    public void clearCart(String userId) {
        cartRepository.clearCart(userId);
    }

    public boolean checkIfUserExists(String userId) {
        if (userId.startsWith("guest-")) {
            return true; // Guest users don't exist in `user-service`
        }
        ResponseEntity<Boolean> response = userService.doesUserExist(userId);
        return response.getStatusCode().is2xxSuccessful() && response.getBody();
    }

    public boolean checkIfProductExists(String productId) {
        ResponseEntity<ProductDto> response = productService.getProductById(productId);
        return response.getStatusCode().is2xxSuccessful();
    }
}
