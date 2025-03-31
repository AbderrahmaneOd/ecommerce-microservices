package com.simpleproject.productservice.repository;

import com.simpleproject.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'name': {'$regex': ?0, '$options': 'i'}}")
    Page<Product> findByNameLike(String name, Pageable pageable);

    Optional<Product> findBySkuCode(String skuCode);
}
