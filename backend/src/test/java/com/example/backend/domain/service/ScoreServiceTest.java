package com.example.backend.domain.service;

import com.example.backend.domain.model.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreServiceTest {

    @Autowired
    ScoreService scoreService;

    @Test
    void getTopFiveSuccessfully() {
        List<Score> topFive = scoreService.getTopFive();

        assertEquals(5, topFive.size());
        for (Score item : topFive) {
            assertNotNull(item);
        }
    }

    @Test
    void getHighestScoreSuccessfully() {
        Score expected = Score.builder()
                .id(1)
                .name("Tim")
                .count(3)
                .build();

        Score actual = scoreService.getHighestScore();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void saveScoreSuccessfully() {
        Score expected = Score.builder()
                .name("Test")
                .count(2)
                .build();

        Score actual = scoreService.saveScore("Test", 2);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCount(), actual.getCount());
    }
}