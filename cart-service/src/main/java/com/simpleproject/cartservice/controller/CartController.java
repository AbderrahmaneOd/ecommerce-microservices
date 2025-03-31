package com.simpleproject.cartservice.controller;

import com.simpleproject.cartservice.dto.AddToCartRequest;
import com.simpleproject.cartservice.model.CartItem;
import com.simpleproject.cartservice.service.CartService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> addItemToCart(@PathVariable String userId, @RequestBody CartItem item) {
        boolean isAdded = cartService.addItemToCart(userId, item);

        if (isAdded) {
            return ResponseEntity.ok(
                    Map.of("message", "Item successfully added to cart", "userId", userId)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "User not found. Please register.")
            );
        }
    }*/

    @PostMapping("/{userId}/add")
    public ResponseEntity<String> addItemToCart(
            @PathVariable String userId,
            @RequestBody AddToCartRequest request) {

        cartService.addItemToCart(userId, request);
        return ResponseEntity.ok("Item added to cart successfully");
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
