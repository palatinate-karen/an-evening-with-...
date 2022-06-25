package com.example.backend.domain.service;

import com.example.backend.infrastructure.service.KanyeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealCitesKanyeService implements RealCitesStrategy{

    @Autowired
    KanyeClient kanyeClient;

    @Override
    public String getCite() {
        return kanyeClient.getCiteFromApi();
    }
}
