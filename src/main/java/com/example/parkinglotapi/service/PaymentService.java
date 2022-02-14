package com.example.parkinglotapi.service;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    // This class is just an emulation

    public BigDecimal payment(ParkingRegistryDto parkingRegistryDto) {

        // Call the payment method and update ParkingSpot.free to true

        return new BigDecimal("0.00");
    }
}
