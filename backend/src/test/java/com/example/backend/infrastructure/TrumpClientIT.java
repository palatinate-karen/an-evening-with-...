package com.example.backend.infrastructure;

import com.example.backend.infrastructure.service.TrumpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrumpClientIT {

    @Autowired
    TrumpClient trumpClient;

    @Test
    void getsCiteSuccessfullyFromApi() {
        String citeFromApi = trumpClient.getCiteFromApi();
        System.out.println(citeFromApi);
        assertNotNull(citeFromApi);
    }
}