package com.example.backend.domain.service;

import com.example.backend.domain.model.Quote;
import com.example.backend.infrastructure.service.KanyeClient;
import com.example.backend.infrastructure.service.TrumpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CitesServiceTest {

    @MockBean
    TrumpClient trumpClient;

    @MockBean
    KanyeClient kanyeClient;

    @Autowired
    CitesService citesService;

    @Test
    void getAnyTrumpCiteSuccessfully() {
        String expectedCite = "Perhaps I am a expectedCite of Trump.";
        when(trumpClient.getCiteFromApi()).thenReturn(expectedCite);

        Quote actualCite = citesService.getQuote("trump");

        assertTrue(expectedCite.equals(actualCite.getCite()) || actualCite.getCite() != null);
    }

    @Test
    void getAnyKanyeCiteSuccessfully() {
        String expectedCite = "Perhaps I am a cite of Kanye.";
        when(kanyeClient.getCiteFromApi()).thenReturn(expectedCite);

        Quote actualCite = citesService.getQuote("kanye");

        assertTrue(expectedCite.equals(actualCite.getCite()) || actualCite.getCite() != null);
    }
}