package com.example.jsonscrapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostProcessingServiceTest {

    @InjectMocks
    PostProcessingService postProcessingService;

    @Mock
    PostScrapper postScrapper;

    @Mock
    JsonSaver jsonSaver;

    @Test
    void shouldProcessPosts() {
        //given
        when(postScrapper.retrievePosts()).thenReturn(List.of(
                new Post(1L, "id1", "title1", "body1"),
                new Post(2L, "id2", "title2", "body2")
        ));

        //when
        postProcessingService.startScrapping();

        //then
        verify(jsonSaver, times(2)).savePost(any(Post.class));
    }
}