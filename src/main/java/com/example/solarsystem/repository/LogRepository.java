package com.example.solarsystem.repository;

import com.example.solarsystem.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
