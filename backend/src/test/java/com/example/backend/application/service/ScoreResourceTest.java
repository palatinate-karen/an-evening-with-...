package com.example.backend.application.service;

import com.example.backend.application.model.NewScore;
import com.example.backend.domain.model.Score;
import com.example.backend.domain.service.ScoreService;
import com.example.backend.infrastructure.service.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ScoreResourceTest {

    @Mock
    ScoreService scoreService;

    @InjectMocks
    ScoreResource scoreResourceWithMockedService;

    @Autowired
    ScoreResource scoreResource;

    @Autowired
    ScoreRepository scoreRepository;

    @Test
    void getHighestScoreSuccessfully() {
        Score expectedTop = scoreRepository.findTopByOrderByCountDesc().get(0);
        Score actualTop = scoreResource.getHighestScore();
        assertEquals(expectedTop, actualTop);
    }

    @Test
    void getTop5Successfully() {
        List<Score> expectedTop5 = scoreRepository.findTop5ByOrderByCountDesc();
        List<Score> actualTop5 = scoreResource.getTop5();
        assertEquals(expectedTop5, actualTop5);
    }

    @Test
    void saveNewScoreSuccessfully() {
        scoreResourceWithMockedService.saveNewScore(NewScore.builder().name("Test").score(10).build());
        verify(scoreService, times(1)).saveScore("Test", 10);
    }
}