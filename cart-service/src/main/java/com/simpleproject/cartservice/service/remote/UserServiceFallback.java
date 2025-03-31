package com.simpleproject.cartservice.service.remote;

import com.simpleproject.cartservice.dto.UserDto;
import com.simpleproject.cartservice.exception.UserNotFoundException;
import com.simpleproject.cartservice.service.remote.UserServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceClient {

    @Override
    public ResponseEntity<Boolean> doesUserExist(String id) {
        return ResponseEntity.ok(false); // Default response when user-service fails
    }

    @Override
    public ResponseEntity<UserDto> getUserById(String userId) {
        //return ResponseEntity.ok().body(new UserDto());
        throw new UserNotFoundException("User not found, fallback triggered for userId: " + userId);
    }
}