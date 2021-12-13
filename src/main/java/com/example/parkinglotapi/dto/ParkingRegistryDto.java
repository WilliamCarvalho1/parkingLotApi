package com.example.parkinglotapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ParkingRegistryDto {

    private Long id;
    private String initialTime;
    private BigDecimal pricePerMinute;
    private Long parkingSpotId;
    private String floorName;

}
