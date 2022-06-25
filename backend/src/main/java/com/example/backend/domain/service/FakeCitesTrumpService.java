package com.example.backend.domain.service;

import com.example.backend.domain.model.CitesTrump;
import com.example.backend.infrastructure.service.CitesTrumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class FakeCitesTrumpService implements FakeCitesStrategy {

    @Autowired
    private final CitesTrumpRepository repository;
    private Random random;

    public FakeCitesTrumpService(CitesTrumpRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getCite() {
        int randomId = getRandomId();
        Optional<CitesTrump> cite = repository.findById(randomId);
        try {
            return cite.orElseThrow().getCite();
        } catch (NoSuchElementException e) {
            return "Joker: It's a fake cite.";
        }
    }

    private int getRandomId() {
        long rows = repository.count();
        random = new Random();
        return random.nextInt((int) rows) + 1;
    }
}
