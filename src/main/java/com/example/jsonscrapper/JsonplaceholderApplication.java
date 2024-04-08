package com.example.jsonscrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JsonscrapperProperties.class)
public class JsonplaceholderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonplaceholderApplication.class, args);
	}

}
