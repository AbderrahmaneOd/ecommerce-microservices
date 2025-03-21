package com.simpleproject.cartservice.service;

import io.lettuce.core.dynamic.annotation.CommandNaming;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceClient {

    @Override
    public ResponseEntity<Boolean> doesUserExist(String id) {
        return ResponseEntity.ok(false); // Default response when user-service fails
    }
}