package com.example.backend.infrastructure.service;

import com.example.backend.infrastructure.model.TrumpQuote;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TrumpClient {

    private static final String URL = "https://www.tronalddump.io/random/quote";


    public String getCiteFromApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl(URL)
                .build();

        TrumpQuote quote = webClient
                .get()
                .retrieve()
                .bodyToMono(TrumpQuote.class)
                .block();

        return quote.getValue();
    }
}
