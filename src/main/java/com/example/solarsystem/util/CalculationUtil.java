package com.example.solarsystem.util;

public class CalculationUtil {

    /**
     * 발전량 비율을 계산하는 유틸리티 메서드
     * @param generatedPower 현재 발전량 (kW)
     * @param totalCapacity 전체 발전 용량 (kW)
     * @return 발전 비율 (%)
     */
    public static double calculateGenerationRate(double generatedPower, double totalCapacity) {
        if (totalCapacity == 0) {
            throw new IllegalArgumentException("전체 용량이 0일 수 없습니다.");
        }
        return (generatedPower / totalCapacity) * 100;
    }

    /**
     * 배터리 충전량을 계산하는 유틸리티 메서드
     * @param initialLevel 초기 배터리 충전 상태 (%)
     * @param generatedPower 발전량 (kW)
     * @param consumptionRate 소비율 (kW)
     * @return 최종 배터리 충전 상태 (%)
     */
    public static double calculateBatteryLevel(double initialLevel, double generatedPower, double consumptionRate) {
        double newLevel = initialLevel + generatedPower - consumptionRate;
        return Math.max(0, Math.min(newLevel, 100)); // 0% ~ 100% 사이로 제한
    }

    /**
     * 송전량을 계산하는 유틸리티 메서드
     * @param generatedPower 현재 발전량 (kW)
     * @param batteryLevel 배터리 충전 상태 (%)
     * @param threshold 송전 시작 배터리 한계 (%)
     * @return 송전량 (kW)
     */
    public static double calculateTransmissionAmount(double generatedPower, double batteryLevel, double threshold) {
        return batteryLevel >= threshold ? generatedPower : 0;
    }
}
