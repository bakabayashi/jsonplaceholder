package com.example.jsonscrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class PostScrapper {

    private final RestTemplate restTemplate;
    private final JsonscrapperProperties jsonscrapperProperties;

    List<Post> retrievePosts() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(
                jsonscrapperProperties.postsApi(),
                Post[].class
        );

        return response.hasBody() ? Arrays.asList(response.getBody()) : new ArrayList<>();
    }
}
