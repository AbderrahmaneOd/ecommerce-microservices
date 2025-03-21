package com.simpleproject.cartservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-service", path = "/api/users")
@FeignClient(name = "user-service", url = "${user.service.url}", fallback = UserServiceFallback.class)
public interface UserServiceClient {

    @GetMapping("/{id}/exists")
    ResponseEntity<Boolean> doesUserExist(@PathVariable String id);
}
