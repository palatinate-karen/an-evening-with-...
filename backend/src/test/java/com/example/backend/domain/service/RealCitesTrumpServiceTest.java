package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.TrumpClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RealCitesTrumpServiceTest {

    @Mock
    TrumpClient trumpClient;

    @InjectMocks
    RealCitesTrumpService realCitesTrumpService;

    @Test
    void getCite() {
        String expected = "I am a actual of Trump.";
        when(trumpClient.getCiteFromApi()).thenReturn(expected);

        String actual = realCitesTrumpService.getCite();

        assertEquals(expected, actual);
    }
}