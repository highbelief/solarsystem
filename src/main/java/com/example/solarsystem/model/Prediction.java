package com.example.solarsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime observationTime; // 예측 관측 시간

    @Column(nullable = false)
    private Double predictedPowerGenerated; // 예측 발전량 (kW)

    @Column(nullable = false)
    private Double predictedBatteryLevel; // 예측 배터리 상태 (%)

    @Column(length = 255)
    private String predictedEquipmentStatus; // 예측 장비 상태 (예: 정상, 고장 등)

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 생성 시간

    // 기본 생성자
    public Prediction() {
    }

    // 모든 필드를 사용하는 생성자
    public Prediction(LocalDateTime observationTime, Double predictedPowerGenerated,
                      Double predictedBatteryLevel, String predictedEquipmentStatus) {
        this.observationTime = observationTime;
        this.predictedPowerGenerated = predictedPowerGenerated;
        this.predictedBatteryLevel = predictedBatteryLevel;
        this.predictedEquipmentStatus = predictedEquipmentStatus;
    }

    // Getter와 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(LocalDateTime observationTime) {
        this.observationTime = observationTime;
    }

    public Double getPredictedPowerGenerated() {
        return predictedPowerGenerated;
    }

    public void setPredictedPowerGenerated(Double predictedPowerGenerated) {
        this.predictedPowerGenerated = predictedPowerGenerated;
    }

    public Double getPredictedBatteryLevel() {
        return predictedBatteryLevel;
    }

    public void setPredictedBatteryLevel(Double predictedBatteryLevel) {
        this.predictedBatteryLevel = predictedBatteryLevel;
    }

    public String getPredictedEquipmentStatus() {
        return predictedEquipmentStatus;
    }

    public void setPredictedEquipmentStatus(String predictedEquipmentStatus) {
        this.predictedEquipmentStatus = predictedEquipmentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
