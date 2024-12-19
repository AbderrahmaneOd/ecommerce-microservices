package com.simpleproject.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto implements Serializable {
    //private Long id;
    private String skuCode; // Stock Keeping Unit code, unique product identifier
    private BigDecimal unitPrice;
    private Integer quantity;
}
