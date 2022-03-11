package com.example.parkinglotapi.controller;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.helper.ParkingRegistryDtoHelper;
import com.example.parkinglotapi.service.PaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @InjectMocks
    private PaymentController controller;

    @Mock
    private PaymentService service;

    @Test
    @DisplayName("Should pay the bill")
    void shouldAllocateVehicle() {

        var requestMock = ParkingRegistryDtoHelper.getParkingRegistryDto();
        var responseMock = new BigDecimal("0.00");

        when(service.payment(any(ParkingRegistryDto.class)))
                .thenReturn(responseMock);

        var response = controller.payment(requestMock);

        assertEquals(responseMock, response.getBody());
    }

}