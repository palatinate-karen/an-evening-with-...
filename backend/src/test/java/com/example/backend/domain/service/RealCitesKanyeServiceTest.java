package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.KanyeClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RealCitesKanyeServiceTest {

    @Mock
    KanyeClient kanyeClient;

    @InjectMocks
    RealCitesKanyeService realCitesKanyeService;

    @Test
    void getsCiteSuccessfully() {
        String expected = "I am a actual of Kanye.";
        when(kanyeClient.getCiteFromApi()).thenReturn(expected);

        String actual = realCitesKanyeService.getCite();

        assertEquals(expected, actual);
    }
}