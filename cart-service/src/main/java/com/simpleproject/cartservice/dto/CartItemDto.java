package com.simpleproject.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private String productId;
    private String skuCode;
    private String productName;
    private double price;
    private int quantity;
    private double subtotal;
}