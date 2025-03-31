package com.simpleproject.cartservice.service.remote;

import com.simpleproject.cartservice.config.FeignErrorDecoder;
import com.simpleproject.cartservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-service", path = "/api/users")
@FeignClient(
        name = "user-service",
        url = "${user.service.url}",
        //fallback = UserServiceFallback.class,
        configuration = FeignErrorDecoder.class)
public interface UserServiceClient {

    @GetMapping("/{id}/exists")
    ResponseEntity<Boolean> doesUserExist(@PathVariable String id);

    @GetMapping("{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable String userId);
}
