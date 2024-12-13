package com.simpleproject.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String skuCode;
}
