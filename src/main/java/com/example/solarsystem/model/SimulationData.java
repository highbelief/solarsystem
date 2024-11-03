package com.example.solarsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SimulationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime observationTime;
    private Double powerGenerated;
    private Double batteryLevel;
    private Double transmissionAmount;

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

    public Double getPowerGenerated() {
        return powerGenerated;
    }

    public void setPowerGenerated(Double powerGenerated) {
        this.powerGenerated = powerGenerated;
    }

    public Double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Double getTransmissionAmount() {
        return transmissionAmount;
    }

    public void setTransmissionAmount(Double transmissionAmount) {
        this.transmissionAmount = transmissionAmount;
    }
}
