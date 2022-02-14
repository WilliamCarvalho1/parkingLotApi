package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.model.ParkingRegistry;

import java.math.BigDecimal;

public class ParkingRegistryHelper {
    public static ParkingRegistry getParkingRegistry() {

        return ParkingRegistry.builder()
                .id(13L)
                .initialTime("2022/02/13 05:16:43")
                .pricePerMinute(new BigDecimal("3"))
                .parkingSpotId(8L)
                .floorName("ground")
                .build();

    }
}
