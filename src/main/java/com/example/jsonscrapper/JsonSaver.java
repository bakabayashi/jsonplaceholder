package com.example.jsonscrapper;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
class JsonSaver {

    private final JsonscrapperProperties jsonscrapperProperties;
    private final ObjectMapper objectMapper;

    void savePost(Post post) {
        String id = post.id();
        try {
            objectMapper.writeValue(new File(getFileName(id)), post);
        } catch (IOException e) {
            log.error("Unable to save post with id={}.", id);
        }
    }

    private String getFileName(String id) {
        return jsonscrapperProperties.savedPostsPath() + "/" + id + ".json";
    }
}
