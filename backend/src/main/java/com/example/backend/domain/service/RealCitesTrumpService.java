package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.TrumpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealCitesTrumpService implements  RealCitesStrategy {

    @Autowired
    TrumpClient trumpClient;

    @Override
    public String getCite() {
        return trumpClient.getCiteFromApi();
    }
}
