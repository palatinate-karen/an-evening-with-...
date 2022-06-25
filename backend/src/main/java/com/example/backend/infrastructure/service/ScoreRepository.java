package com.example.backend.infrastructure.service;

import com.example.backend.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "score")
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findTop5ByOrderByCountDesc();
    List<Score> findTopByOrderByCountDesc();
}
