package com.example.backend.application.service;

import com.example.backend.domain.service.CitesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CitesResourceTest {

    @Mock
    CitesService citesService;

    @InjectMocks
    CitesResource citesResource;

    @Test
    void getNextCiteTrump() {
        String expected = "Perhaps I am a Trump cite.";
        when(citesService.getCite("Trump")).thenReturn(expected);

        String actual = citesResource.getNextCite("Trump");

        assertEquals(expected, actual);
    }
}