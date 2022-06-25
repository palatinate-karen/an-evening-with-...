package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.KanyeClient;
import com.example.backend.infrastructure.service.TrumpClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CitesServiceTest {

    @Mock
    TrumpClient trumpClient;

    @Mock
    KanyeClient kanyeClient;

    @Autowired
    @InjectMocks
    CitesService citesService;

    @Test
    void getAnyTrumpCiteSuccessfully() {
        when(trumpClient.getCiteFromApi()).thenReturn("Perhaps I am a cite of Trump.");
        assertNotNull(citesService.getCite("Trump"));
    }

    @Test
    void getAnyKanyeCiteSuccessfully() {
        when(kanyeClient.getCiteFromApi()).thenReturn("Perhaps I am a cite of Kanye.");
        assertNotNull(citesService.getCite("Kanye"));
    }
}