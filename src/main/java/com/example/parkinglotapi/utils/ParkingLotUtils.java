package com.example.parkinglotapi.utils;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.enums.ParkingSpotType;
import com.example.parkinglotapi.model.ParkingRegistry;
import com.example.parkinglotapi.model.ParkingSpot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static ParkingRegistry buildParkingRegistry(ParkingSpot parkingSpot, String floorName) {
        return ParkingRegistry.builder()
                .initialTime(getFormattedInitialTime())
                .floorName(floorName)
                .parkingSpotId(parkingSpot.getId())
                .pricePerMinute(getPricePerMinute(parkingSpot.getType()))
                .build();
    }

    public static String getFormattedInitialTime() {
        var formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:s");
        return LocalDateTime.now().format(formatter);
    }

    public static BigDecimal getPricePerMinute(ParkingSpotType parkingSpotType) {
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
