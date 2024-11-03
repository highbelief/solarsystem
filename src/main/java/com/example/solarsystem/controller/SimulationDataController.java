package com.example.solarsystem.controller;

import com.example.solarsystem.service.SimulationDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class SimulationDataController {

    private final SimulationDataService service;

    public SimulationDataController(SimulationDataService service) {
        this.service = service;
    }

    @GetMapping("/chart")
    public Map<String, Object> getChartData() {
        return service.getChartData();
    }
}
