package com.example.backend.infrastructure;

import com.example.backend.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "score")
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
