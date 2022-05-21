package com.example.backend.application;

import com.example.backend.application.service.TestController;
import com.example.backend.domain.model.Score;
import com.example.backend.infrastructure.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestControllerTest {

    @Autowired
    private TestController testController;

    @Autowired
    private ScoreRepository scoreRepository;

    @Test
    void validateTestSchnitstelleSavesNewScoreToEmptyTable() {
        Score score = Score.builder()
                .id(1)
                .name("abc")
                .count(1)
                .build();

        testController.testSchnittstelle();
        List<Score> all = scoreRepository.findAll();

        assertEquals(1, all.size());
        assertEquals(score, all.get(0));
    }
}