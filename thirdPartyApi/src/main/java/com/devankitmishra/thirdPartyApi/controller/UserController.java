package com.devankitmishra.thirdPartyApi.controller;

import com.devankitmishra.thirdPartyApi.model.User;
import com.devankitmishra.thirdPartyApi.service.UserService;
import com.devankitmishra.thirdPartyApi.service.WebClientUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final WebClientUserService webClientUserService;

    public UserController(UserService userService, WebClientUserService webClientUserService) {
        this.userService = userService;
        this.webClientUserService = webClientUserService;
    }

    @GetMapping("/rest/{id}")
    public User getUserUsingRestTemplate(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/webclient/{id}")
    public Mono<User> getUserUsingWebClient(@PathVariable int id) {
        return webClientUserService.getUser(id);
    }

    // ✅ Correctly mapped endpoint for fetching all users
    @GetMapping("/all")
    public Flux<User> getAllUsers() {
        return webClientUserService.getAllUsers();
    }
}
