package com.example.backend.domain.service;

import com.example.backend.domain.model.CitesKanye;
import com.example.backend.infrastructure.service.CitesKanyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class FakeCitesKanyeService implements FakeCitesStrategy {
    @Autowired
    private final CitesKanyeRepository repository;
    private Random random;

    public FakeCitesKanyeService(CitesKanyeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getCite() {
        int randomId = getRandomId();
        Optional<CitesKanye> cite = repository.findById(randomId);
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
