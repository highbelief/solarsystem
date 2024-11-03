package com.example.solarsystem.repository;

import com.example.solarsystem.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {

    @Query("SELECT p FROM Prediction p WHERE p.observationTime BETWEEN :start AND :end ORDER BY p.observationTime ASC")
    List<Prediction> findPredictionsForDateRange(LocalDateTime start, LocalDateTime end);

}