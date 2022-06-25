package com.example.backend.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CitesResourceTest {

    @Autowired
    CitesResource citesResource;

    @Test
    void getNextCiteTrump() {
        assertNotNull(citesResource.getNextCite("Trump"));
    }
}