package com.example.solarsystem.service;

import com.example.solarsystem.model.SimulationData;
import com.example.solarsystem.repository.SimulationDataRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SimulationDataService {

    private final SimulationDataRepository repository;

    public SimulationDataService(SimulationDataRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> getChartData() {
        List<SimulationData> dataList = repository.findAll();

        List<String> timestamps = dataList.stream()
                .map(data -> data.getObservationTime().toString())
                .collect(Collectors.toList());

        List<Double> powerGenerated = dataList.stream()
                .map(SimulationData::getPowerGenerated)
                .collect(Collectors.toList());

        List<Double> batteryLevel = dataList.stream()
                .map(SimulationData::getBatteryLevel)
                .collect(Collectors.toList());

        return Map.of(
                "timestamps", timestamps,
                "powerGenerated", powerGenerated,
                "batteryLevel", batteryLevel
        );
    }

}
