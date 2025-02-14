package com.devankitmishra.thirdPartyApi.service;

import com.devankitmishra.thirdPartyApi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUser(int userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    }
}

