package com.example.solarsystem.dto;

public class SimulationDataResponse {
    private Double currentPower;
    private Double batteryLevel;
    private Double transmissionAmount;

    public SimulationDataResponse(Double currentPower, Double batteryLevel, Double transmissionAmount) {
        this.currentPower = currentPower;
        this.batteryLevel = batteryLevel;
        this.transmissionAmount = transmissionAmount;
    }

    public Double getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(Double currentPower) {
        this.currentPower = currentPower;
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
