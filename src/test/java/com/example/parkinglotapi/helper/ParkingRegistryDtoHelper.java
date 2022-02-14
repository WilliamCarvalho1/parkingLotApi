package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.dto.ParkingRegistryDto;

import java.math.BigDecimal;

public class ParkingRegistryDtoHelper {
    public static ParkingRegistryDto getParkingRegistryDto() {

        return ParkingRegistryDto.builder()
                .id(13L)
                .initialTime("2022/02/13 05:16:43")
                .pricePerMinute(new BigDecimal("3"))
                .parkingSpotId(8L)
                .floorName("ground")
                .build();

    }
}
