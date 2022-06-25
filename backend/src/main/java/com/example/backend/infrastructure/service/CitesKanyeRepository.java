package com.example.backend.infrastructure.service;

import com.example.backend.domain.model.CitesKanye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "kanye")
public interface CitesKanyeRepository extends JpaRepository<CitesKanye, Integer> {
}
