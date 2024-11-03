package com.example.solarsystem.repository;

import com.example.solarsystem.model.SimulationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationDataRepository extends JpaRepository<SimulationData, Long> {
}
