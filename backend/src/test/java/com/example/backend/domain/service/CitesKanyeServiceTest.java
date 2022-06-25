package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.CitesKanyeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class CitesKanyeServiceTest {

    @Autowired
    FakeCitesKanyeService kanyeService;

    @Mock
    CitesKanyeRepository kanyeRepositoryMock;

    @InjectMocks
    FakeCitesKanyeService kanyeServiceWithMock;


    @Test
    void getsRandomCite() {
        String result = kanyeService.getCite();

        assertNotNull(result);
        assertNotEquals(0, result.length());
    }

    @Test
    void getsJoker() {
        when(kanyeRepositoryMock.count()).thenReturn(6L);
        when(kanyeRepositoryMock.findById(anyInt())).thenReturn(Optional.empty());

        String result = kanyeServiceWithMock.getCite();
        assertEquals("Joker: It's a fake cite.", result);
    }
}