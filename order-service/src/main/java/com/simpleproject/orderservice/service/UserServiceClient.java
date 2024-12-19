package com.simpleproject.orderservice.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceClient {

    private final WebClient.Builder webClientBuilder;

    // Inject inventory service URL from properties
    @Value("${user.service.url}")
    private String userServiceUrl;

    // Define resilience4j annotations for retry, circuit breaker, and timeout
    @Retry(name = "userServiceRetry", fallbackMethod = "fallbackCheckUserExistence")
    @CircuitBreaker(name = "userServiceCircuitBreaker", fallbackMethod = "fallbackCheckUserExistence")
    //@TimeLimiter(name = "userServiceTimeLimiter", fallbackMethod = "fallbackCheckUserExistence")
    public String checkUserExistence(String userId) {

        try{

            // Call inventory service
            return webClientBuilder
                    .baseUrl(userServiceUrl) // Set the base URL here
                    .build()
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/users/exists/{userId}")
                            .build(userId))
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, response -> {
                        if (response.statusCode().equals(HttpStatus.NOT_FOUND)) {
                            return Mono.empty(); // Return empty if user is not found (404)
                        }
                        return Mono.error(new RuntimeException("Client Error: " + response.statusCode()));
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Server Error")))
                    .bodyToMono(String.class)
                    .block(); // Blocking

        } catch (Exception e) {
            log.error("Error occurred while checking user existence", e);
            return null; // Return null if any error occurs
        }
    }

    // Fallback method in case of failures
    public String fallbackCheckUserExistence(String userId, Throwable t) {
        log.error("Failed to check user {}: {}", userId, t.getMessage());
        return "User service is unavailable at the moment, please try again later.";
    }
}
