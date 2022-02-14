package com.example.parkinglotapi.service;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.model.Floor;
import com.example.parkinglotapi.model.ParkingSpot;
import com.example.parkinglotapi.repository.ParkingRegistryRepository;
import com.example.parkinglotapi.utils.ParkingLotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingRegistryService {

    @Autowired
    private ParkingRegistryRepository parkingRegistryRepository;

    public ParkingRegistryDto createParkingRegistry(ParkingSpot parkingSpot, Floor floor) {

        var parkingRegistry = ParkingLotUtils.buildParkingRegistry(parkingSpot, floor);

        parkingRegistryRepository.save(parkingRegistry);

        return ParkingLotUtils.convertToDto(parkingRegistry);

    }

}
