package com.example.jsonscrapper;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jsonscrapper")
record JsonscrapperProperties(
        String postsApi,
        String savedPostsPath
) {

}
