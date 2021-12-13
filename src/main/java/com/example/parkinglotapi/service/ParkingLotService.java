package com.example.parkinglotapi.service;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.dto.VehicleDataDto;
import com.example.parkinglotapi.enums.ParkingSpotType;
import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.model.ParkingRegistry;
import com.example.parkinglotapi.repository.FloorRepository;
import com.example.parkinglotapi.repository.ParkingRegistryRepository;
import com.example.parkinglotapi.repository.ParkingSpotRepository;
import com.example.parkinglotapi.utils.ParkingLotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ParkingRegistryRepository parkingRegistryRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Transactional
    public ParkingRegistryDto allocateVehicle(VehicleDataDto vehicleDataDto) throws NoSpotException {

        var vehicleHeight = vehicleDataDto.getHeight();
        var vehicleWeight = vehicleDataDto.getWeight();

        var parkingSpot = parkingSpotRepository.getAvailableParkingSpot(vehicleHeight, vehicleWeight);

        if (parkingSpot != null) {

            var parkingSpotId = parkingSpot.getId();
            var floorId = parkingSpot.getFloorId();

            parkingSpotRepository.setParkingSpotToOccupied(parkingSpotId);
            floorRepository.updateFloorWeightCapacity(vehicleWeight, floorId);

            var floor = floorRepository.findById(floorId);

            var pricePerMinute = getPricePerMinute(parkingSpot.getType());

            var formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:m:s");
            var initialTime = LocalDateTime.now().format(formatter);

            var parkingRegistry = ParkingRegistry.builder()
                    .initialTime(initialTime)
                    .floorName(floor.getName())
                    .parkingSpotId(parkingSpotId)
                    .pricePerMinute(pricePerMinute)
                    .build();

            parkingRegistryRepository.save(parkingRegistry);

            return ParkingLotUtils.convertToDto(parkingRegistry);
        } else {
            throw new NoSpotException();
        }

    }

    public BigDecimal getPricePerMinute(ParkingSpotType parkingSpotType) {
        switch (parkingSpotType) {
            case SMALL:
                return new BigDecimal("1.00");
            case MEDIUM:
                return new BigDecimal("2.00");
            default:
                return new BigDecimal("3.00");
        }
    }

}
