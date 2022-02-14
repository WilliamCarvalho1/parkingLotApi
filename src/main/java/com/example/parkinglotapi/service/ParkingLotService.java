package com.example.parkinglotapi.service;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.dto.VehicleDataDto;
import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingRegistryService parkingRegistryService;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private FloorService floorService;

    @Transactional
    public ParkingRegistryDto allocateVehicle(VehicleDataDto vehicleDataDto) throws NoSpotException,
            VehicleTooTallException, WeightCapacityException {

        var vehicleHeight = vehicleDataDto.getHeight();
        var vehicleWeight = vehicleDataDto.getWeight();

        var floor = floorService.getSuitableFloor(vehicleHeight, vehicleWeight);

        var parkingSpot = parkingSpotService.getParkingSpot(floor.getId(), vehicleWeight);

        return parkingRegistryService.createParkingRegistry(parkingSpot, floor.getName());

    }

}
