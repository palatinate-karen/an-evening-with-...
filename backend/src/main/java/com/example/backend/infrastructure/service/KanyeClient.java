package com.example.backend.infrastructure.service;

import com.example.backend.infrastructure.model.KanyeQuote;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class KanyeClient {

    private static final String URL = "https://api.kanye.rest/";

    public String getCiteFromApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl(URL)
                .build();

        KanyeQuote quote = webClient
                .get()
                .retrieve()
                .bodyToMono(KanyeQuote.class)
                .block();

        return quote.getQuote();
    }
}
