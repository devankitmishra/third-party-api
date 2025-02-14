package com.devankitmishra.thirdPartyApi.service;

import com.devankitmishra.thirdPartyApi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientUserService {

    private final WebClient webClient;

    public WebClientUserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Mono<User> getUser(int userId) {
        return webClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(User.class);
    }

    // ✅ Added method to get all users
    public Flux<User> getAllUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
}
