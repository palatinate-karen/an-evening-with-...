package com.example.backend.application.service;

import com.example.backend.domain.model.Score;
import com.example.backend.infrastructure.service.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreResourceTest {

    @Autowired
    ScoreResource scoreResource;

    @Autowired
    ScoreRepository scoreRepository;

    @Test
    void getHighestScore() {
        Score expectedTop = scoreRepository.findTopByOrderByCountDesc().get(0);
        Score actualTop = scoreResource.getHighestScore();
        assertEquals(expectedTop, actualTop);
    }

    @Test
    void getTop5() {
        List<Score> expectedTop5 = scoreRepository.findTop5ByOrderByCountDesc();
        List<Score> actualTop5 = scoreResource.getTop5();
        assertEquals(expectedTop5, actualTop5);
    }

    @Test
    void saveNewScore() {
        // TODO
    }
}