package com.simpleproject.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private String skuCode;
    private BigDecimal unitPrice;
    private Integer quantity;
}
