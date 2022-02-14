package com.example.parkinglotapi.service;

import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.model.ParkingSpot;
import com.example.parkinglotapi.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private FloorService floorService;

    public ParkingSpot getParkingSpot(Long floorId, BigDecimal vehicleWeight) throws NoSpotException {

        var parkingSpots = parkingSpotRepository.findAll();

        var parkingSpot = parkingSpots
                .stream()
                .filter(spot -> spot.getFloorId().equals(floorId))
                .filter(ParkingSpot::isFree)
                .findFirst()
                .orElseThrow(NoSpotException::new);

        parkingSpotRepository.setParkingSpotToOccupied(parkingSpot.getId());

        floorService.updateFloorWeightCapacity(vehicleWeight, floorId);

        return parkingSpot;

    }

}
