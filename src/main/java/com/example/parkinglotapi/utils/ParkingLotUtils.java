package com.example.parkinglotapi.utils;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.model.ParkingRegistry;

public class ParkingLotUtils {

    public static ParkingRegistryDto convertToDto(ParkingRegistry entity) {
        return ParkingRegistryDto.builder()
                .id(entity.getId())
                .initialTime(entity.getInitialTime())
                .floorName(entity.getFloorName())
                .parkingSpotId(entity.getParkingSpotId())
                .pricePerMinute(entity.getPricePerMinute())
                .build();
    }

}
