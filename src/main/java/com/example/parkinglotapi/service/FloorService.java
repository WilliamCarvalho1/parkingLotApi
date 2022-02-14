package com.example.parkinglotapi.service;

import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.model.Floor;
import com.example.parkinglotapi.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public Floor getSuitableFloor(BigDecimal vehicleHeight, BigDecimal vehicleWeight) throws VehicleTooTallException,
            WeightCapacityException {

        var floors = floorRepository.findAll();

        floors = floors.stream()
                .filter(f -> f.getCeilingHeight().compareTo(vehicleHeight) >= 0)
                .collect(Collectors.toList());

        if (floors.size() == 0) {
            throw new VehicleTooTallException();
        }

        floors.sort(Comparator.comparing(Floor::getCeilingHeight));

        return floors.stream()
                .filter(f -> f.getCurrentWeightCapacity().compareTo(vehicleWeight) >= 0)
                .findFirst()
                .orElseThrow(WeightCapacityException::new);

    }

    public void updateFloorWeightCapacity(BigDecimal vehicleWeight, Long floorId) {
        floorRepository.updateFloorWeightCapacity(vehicleWeight, floorId);
    }

}
