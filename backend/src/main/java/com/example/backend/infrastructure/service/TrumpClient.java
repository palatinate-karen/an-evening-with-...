package com.example.backend.infrastructure.service;

import com.example.backend.infrastructure.model.TrumpQuote;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TrumpClient {

    private static final String URL = "https://www.tronalddump.io/";


    public String getCiteFromApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl(URL)
                .build();

        // FIXME fertigstellen, wenn Schnittstelle wieder online
        TrumpQuote quote = webClient
                .get()
                .retrieve()
                .bodyToMono(TrumpQuote.class)
                .block();

        return quote.getQuote();
    }
}
