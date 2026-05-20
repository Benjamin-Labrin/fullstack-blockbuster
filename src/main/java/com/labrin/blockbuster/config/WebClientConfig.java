package com.labrin.blockbuster.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



@Configuration
public class WebClientConfig {

    @Value("${openmeteo.base-url}")
    private String openMateoBaseUrl;

    @Bean
    public WebClient weatherWebClient(){
        return WebClient.builder()
            .baseUrl(openMateoBaseUrl)
            .defaultHeader("Accept", "application/json")
            .build();

    }
}
