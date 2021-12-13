package com.example.parkinglotapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class VehicleDataDto {

    private BigDecimal weight;
    private BigDecimal height;

}
