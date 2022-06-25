package com.example.backend.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Returns a Cite either of Kanye or Trump - depending on the parameter which is passed.
 * The decision whether the cite is fake or not is made randomly.
 */
@Service
public class CitesService {

    @Autowired
    FakeCitesTrumpService fakeCitesTrumpService;

    @Autowired
    RealCitesTrumpService realCitesTrumpService;

    @Autowired
    FakeCitesKanyeService fakeCitesKanyeService;

    @Autowired
    RealCitesKanyeService realCitesKanyeService;
    private Random random;

    public String getCite(String celebrity) {
        boolean isFake = decideIfFakeCite();

        String newCite;
        if (isFake) {
            newCite = getFakeCitesService(celebrity).getCite();
        } else {
            newCite = getRealCitesService(celebrity).getCite();
        }

        return newCite;
    }

    private RealCitesStrategy getRealCitesService(String celebrity) {
        if ("Trump".equals(celebrity)) {
            return realCitesTrumpService;
        } else {
            return  realCitesKanyeService;
        }
    }

    private FakeCitesStrategy getFakeCitesService(String celebrity) {
        if ("Trump".equals(celebrity)) {
            return fakeCitesTrumpService;
        } else {
            return  fakeCitesKanyeService;
        }
    }

    private boolean decideIfFakeCite() {
        random = new Random();
        return random.nextBoolean();
    }
}
