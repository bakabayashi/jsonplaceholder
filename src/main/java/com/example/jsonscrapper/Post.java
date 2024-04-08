package com.example.jsonscrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
record Post(
        Long userId,
        String id,
        String title,
        String body
) {

}
