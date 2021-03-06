package com.example.backend.application.service;

import com.example.backend.application.model.NewScore;
import com.example.backend.domain.model.Score;
import com.example.backend.domain.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class ScoreResource {

    @Autowired
    ScoreService scoreService;

    @GetMapping(path = "/highestScore")
    public Score getHighestScore() {
        return scoreService.getHighestScore();
    }

    @GetMapping(path = "/topFive")
    public List<Score> getTop5() {
        return scoreService.getTopFive();
    }

    @PostMapping(path = "saveScore")
    public void saveNewScore(@RequestBody NewScore newScore){
        scoreService.saveScore(newScore.getName(), newScore.getScore());
    }
}
