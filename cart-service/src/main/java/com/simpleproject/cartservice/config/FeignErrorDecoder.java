package com.simpleproject.cartservice.config;

import com.simpleproject.cartservice.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == HttpStatus.NOT_FOUND.value()){
            return new UserNotFoundException("User not found");
        }
        return defaultErrorDecoder.decode(s, response);
    }
}
