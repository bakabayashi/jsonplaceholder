package com.example.jsonscrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class PostScrapperTest {

    @InjectMocks
    PostScrapper postScrapper;

    @Mock
    JsonscrapperProperties jsonscrapperProperties;

    @Mock
    RestTemplate restTemplate;

    @Test
    void shouldScrapPost() {
        //given
        Post[] posts = {
                new Post(1L, "id1", "title1", "body1"),
                new Post(2L, "id2", "title2", "body2")
        };
        String url = "http://com.example/posts";

        when(jsonscrapperProperties.postsApi()).thenReturn(url);
        when(restTemplate.getForEntity(url, Post[].class)).thenReturn(
                new ResponseEntity<>(posts, HttpStatus.OK)
        );
        //when
        List<Post> result = postScrapper.retrievePosts();

        //then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).extracting(
                "userId", "id", "title", "body"
        ).containsExactlyInAnyOrder(
                tuple(1L, "id1", "title1", "body1"),
                tuple(2L, "id2", "title2", "body2")
        );
    }
    @Test
    void shouldNotScrapPost() {
        //given
        String url = "http://com.example/posts";

        when(jsonscrapperProperties.postsApi()).thenReturn(url);
        when(restTemplate.getForEntity(url, Post[].class)).thenReturn(
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
        );
        //when
        List<Post> result = postScrapper.retrievePosts();

        //then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(0);
    }
}