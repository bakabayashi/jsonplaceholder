package com.example.jsonscrapper;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class PostProcessingService {

    private final PostScrapper postScrapper;
    private final JsonSaver jsonSaver;

    @PostConstruct
    void startScrapping() {
        processPosts();
    }

    private void processPosts() {
        postScrapper.retrievePosts().forEach(
                jsonSaver::savePost
        );
    }
}
