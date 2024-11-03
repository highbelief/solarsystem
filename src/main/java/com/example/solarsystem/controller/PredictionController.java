package com.example.solarsystem.controller;

import com.example.solarsystem.service.PredictionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @GetMapping("/tomorrow")
    public Map<String, Object> getTomorrowPredictions() {
        return service.getTomorrowPredictions();
    }
}