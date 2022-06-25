package com.example.backend.infrastructure.service;

import com.example.backend.infrastructure.model.KanyeQuote;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class KanyeClient {

    private final String url = "https://api.kanye.rest/";

    public String getCiteFromApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        KanyeQuote quote = webClient
                .get()
                .retrieve()
                .bodyToMono(KanyeQuote.class)
                .block();

        return quote.getQuote();
    }
}
