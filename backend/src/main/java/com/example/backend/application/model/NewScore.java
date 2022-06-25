package com.example.backend.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NewScore {
    private String name;
    private int score;
}
