package com.example.solarsystem.controller;

import com.example.solarsystem.model.Log;
import com.example.solarsystem.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public List<Log> getLogs() {
        return logService.getAllLogs();
    }
}
