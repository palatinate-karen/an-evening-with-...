package com.example.backend.application.service;

import com.example.backend.infrastructure.ScoreRepository;
import com.example.backend.domain.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // FIXME Verstoß gegen Architektur -> direkter Zugriff auf Infrastructure-Layer
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/test")
    public void testSchnittstelle() {
        scoreRepository.save(Score.builder().id(1).count(1).name("abc").build());
    }
}
