package com.example.parkinglotapi.repository;

import com.example.parkinglotapi.model.ParkingRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRegistryRepository extends JpaRepository<ParkingRegistry, String> {
}
