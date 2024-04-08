package com.example.jsonscrapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
class JsonplaceholderConfig {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
