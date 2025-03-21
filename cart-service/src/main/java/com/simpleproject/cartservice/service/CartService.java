package com.simpleproject.cartservice.service;

import com.simpleproject.cartservice.model.CartItem;
import com.simpleproject.cartservice.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserServiceClient userService;

    public CartService(CartRepository cartRepository, UserServiceClient userService){
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public void addToCart(String userId, CartItem item) {
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
}
