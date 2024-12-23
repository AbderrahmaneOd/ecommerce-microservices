package com.simpleproject.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String skuCode; // A unique identifier for each product

}
