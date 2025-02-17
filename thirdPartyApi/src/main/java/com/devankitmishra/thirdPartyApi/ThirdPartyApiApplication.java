package com.devankitmishra.thirdPartyApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ThirdPartyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApiApplication.class, args);
	}

	// Register RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}


