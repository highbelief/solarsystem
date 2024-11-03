package com.example.solarsystem.service;

import com.example.solarsystem.model.Prediction;
import com.example.solarsystem.repository.PredictionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PredictionService {

    private final PredictionRepository repository;

    public PredictionService(PredictionRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> getTomorrowPredictions() {
        LocalDateTime startOfTomorrow = LocalDate.now().plusDays(1).atStartOfDay();
        LocalDateTime endOfTomorrow = startOfTomorrow.plusDays(1).minusNanos(1);

        List<Prediction> predictions = repository.findPredictionsForDateRange(startOfTomorrow, endOfTomorrow);

        if (predictions.isEmpty()) {
            return Map.of(
                    "predictedPower", Map.of(),
                    "predictedBattery", Map.of()
            );
        }

        Map<String, Double> predictedPower = predictions.stream()
                .collect(Collectors.toMap(
                        p -> p.getObservationTime().toLocalTime().toString(),
                        Prediction::getPredictedPowerGenerated
                ));

        Map<String, Double> predictedBattery = predictions.stream()
                .collect(Collectors.toMap(
                        p -> p.getObservationTime().toLocalTime().toString(),
                        Prediction::getPredictedBatteryLevel
                ));

        return Map.of(
                "predictedPower", predictedPower,
                "predictedBattery", predictedBattery
        );
    }
}
