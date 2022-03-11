package com.example.parkinglotapi.controller;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/parking-lot")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // This endpoint is just an emulation
    @PostMapping("/payment")
    public ResponseEntity<BigDecimal> payment(@RequestBody ParkingRegistryDto parkingRegistryDto) {
        return new ResponseEntity<>(paymentService.payment(parkingRegistryDto), HttpStatus.OK);
    }

}
