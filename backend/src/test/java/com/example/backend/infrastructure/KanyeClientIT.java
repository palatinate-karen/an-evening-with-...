package com.example.backend.infrastructure;

import com.example.backend.infrastructure.service.KanyeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KanyeClientIT {

    @Autowired
    KanyeClient kanyeClient;

    @Test
    void getsCiteSuccessfullyFromApi() {
        String citeFromApi = kanyeClient.getCiteFromApi();
        System.out.println(citeFromApi);
        assertNotNull(citeFromApi);
    }
}