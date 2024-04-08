package com.example.jsonscrapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@ExtendWith(MockitoExtension.class)
class JsonSaverTest {

    @InjectMocks
    JsonSaver jsonSaver;

    @Mock
    JsonscrapperProperties jsonscrapperProperties;

    @Mock
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void shouldSavePost() {
        //given
        Post post = new Post(1L, "id1", "title", "lorem ipsum");

        //when
        jsonSaver.savePost(post);

        //then
        verify(objectMapper).writeValue(any(File.class), eq(post));
    }
}