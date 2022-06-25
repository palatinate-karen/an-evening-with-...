package com.example.backend.application.service;

import com.example.backend.domain.service.CitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitesResource {

    @Autowired
    CitesService citesService;

    @GetMapping(path = "/cite")
    public String getNextCite(@RequestParam String celebrity) {
         return citesService.getCite(celebrity);
    }
}
