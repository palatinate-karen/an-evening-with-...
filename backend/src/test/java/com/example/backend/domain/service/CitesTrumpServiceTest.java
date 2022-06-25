package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.CitesTrumpRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class CitesTrumpServiceTest {

    @Autowired
    FakeCitesTrumpService trumpService;

    @Mock
    CitesTrumpRepository trumpRepositoryMock;

    @InjectMocks
    FakeCitesTrumpService trumpServiceWithMock;

    @Test
    void getsRandomCite() {
        String result = trumpService.getCite();

        assertNotNull(result);
        assertNotEquals(0, result.length());
    }

    @Test
    void getsJoker() {
        when(trumpRepositoryMock.count()).thenReturn(6L);
        when(trumpRepositoryMock.findById(anyInt())).thenReturn(Optional.empty());

        String result = trumpServiceWithMock.getCite();
        assertEquals("Joker: It's a fake cite.", result);
    }
}