package com.example.parkinglotapi.service;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.model.ParkingSpot;
import com.example.parkinglotapi.repository.ParkingRegistryRepository;
import com.example.parkinglotapi.utils.ParkingLotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingRegistryService {

    @Autowired
    private ParkingRegistryRepository parkingRegistryRepository;

    public ParkingRegistryDto createParkingRegistry(ParkingSpot parkingSpot, String floorName) {

        var parkingRegistry = ParkingLotUtils.buildParkingRegistry(parkingSpot, floorName);

        parkingRegistryRepository.save(parkingRegistry);

        return ParkingLotUtils.convertToDto(parkingRegistry);

    }

}
