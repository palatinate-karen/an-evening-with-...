package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.KanyeClient;
import com.example.backend.infrastructure.service.TrumpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        when(trumpClient.getCiteFromApi()).thenReturn("Perhaps I am a cite of Trump.");
        assertNotNull(citesService.getCite("Trump"));
    }

    @Test
    void getAnyKanyeCiteSuccessfully() {
        when(kanyeClient.getCiteFromApi()).thenReturn("Perhaps I am a cite of Kanye.");
        assertNotNull(citesService.getCite("Kanye"));
    }
}