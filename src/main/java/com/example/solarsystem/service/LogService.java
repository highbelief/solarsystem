package com.example.solarsystem.service;

import com.example.solarsystem.model.Log;
import com.example.solarsystem.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();  // 데이터베이스에서 모든 로그 데이터 조회
    }
}
