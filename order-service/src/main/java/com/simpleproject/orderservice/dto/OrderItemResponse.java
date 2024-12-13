package com.simpleproject.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemResponse {
    private String skuCode;
    private BigDecimal unitPrice;
    private Integer quantity;
}
