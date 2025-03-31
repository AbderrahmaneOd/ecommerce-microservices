package com.simpleproject.cartservice.repository;

import com.simpleproject.cartservice.dto.AddToCartRequest;
import com.simpleproject.cartservice.model.CartItem;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    private final RedisTemplate<String, Object> redisTemplate;

    public CartRepository(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    private static final String CART_PREFIX = "cart:";

    public void addToCart(String userId, AddToCartRequest item) {
        String key = CART_PREFIX + userId;
        redisTemplate.opsForList().rightPush(key, item);
        System.out.println("Item added to cart: " + item);
    }

    public List<Object> getCart(String userId) {
        return redisTemplate.opsForList().range(CART_PREFIX + userId, 0, -1);
    }

    public void removeCartItem(String userId, CartItem item) {
        redisTemplate.opsForList().remove(CART_PREFIX + userId, 1, item);
    }

    public void clearCart(String userId) {
        redisTemplate.delete(CART_PREFIX + userId);
    }
}
