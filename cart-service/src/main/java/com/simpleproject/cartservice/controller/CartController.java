package com.simpleproject.cartservice.controller;

import com.simpleproject.cartservice.model.CartItem;
import com.simpleproject.cartservice.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    public final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    /*@PostMapping("/{userId}/add")
    public void addToCart(@PathVariable String userId, @RequestBody CartItem item) {
        cartService.addToCart(userId, item);
    }*/

    @PostMapping("/{userId}/add")
    public ResponseEntity<Map<String, String>> addToCart(@PathVariable String userId, @RequestBody CartItem item) {
        String effectiveUserId = userId;

        if (userId.equalsIgnoreCase("guest")) {
            effectiveUserId = "guest-" + UUID.randomUUID();
        } else if (!cartService.checkIfUserExists(userId)) {
            return ResponseEntity.badRequest().body(Map.of("error", "User not found. Please register."));
        }

        cartService.addToCart(effectiveUserId, item);

        return ResponseEntity.ok(Map.of("message", "Item added to cart", "userId", effectiveUserId));
    }

    @GetMapping("/{userId}")
    public List<Object> getCart(@PathVariable String userId) {
        return cartService.getCart(userId);
    }

    @DeleteMapping("/{userId}/remove")
    public void removeCartItem(@PathVariable String userId, @RequestBody CartItem item) {
        cartService.removeCartItem(userId, item);
    }

    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }

}
