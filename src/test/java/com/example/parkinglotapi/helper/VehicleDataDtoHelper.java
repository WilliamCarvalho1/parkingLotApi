package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.dto.VehicleDataDto;

import java.math.BigDecimal;

public class VehicleDataDtoHelper {
    public static VehicleDataDto getVehicleDataDto() {

        return VehicleDataDto.builder()
                .weight(new BigDecimal("500"))
                .height(new BigDecimal("1.50"))
                .build();

    }
}
