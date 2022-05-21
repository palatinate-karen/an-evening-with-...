package com.example.backend.infrastructure;

import com.example.backend.domain.model.CitesTrump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "trump")
public interface CitesTrumpRepository extends JpaRepository<CitesTrump, Integer> {
}
