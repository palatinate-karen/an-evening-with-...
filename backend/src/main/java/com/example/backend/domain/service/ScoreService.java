package com.example.backend.domain.service;

import com.example.backend.domain.model.Score;
import com.example.backend.infrastructure.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository repository;

    public List<Score> getTopFive() {
        return repository.findTop5ByOrderByCountDesc();
    }

    public Score getHighestScore() {
        return repository.findTopByOrderByCountDesc().get(0);
    }

    public Score saveScore(String name, int score) {
        Score newScore = Score.builder()
                .name(name)
                .count(score)
                .build();
        return repository.save(newScore);
    }
}
