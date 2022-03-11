package com.example.parkinglotapi.controller;

import com.example.parkinglotapi.dto.VehicleDataDto;
import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.helper.ParkingRegistryDtoHelper;
import com.example.parkinglotapi.helper.VehicleDataDtoHelper;
import com.example.parkinglotapi.service.ParkingLotService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingLotControllerTest {

    @InjectMocks
    private ParkingLotController controller;

    @Mock
    private ParkingLotService service;

    @Test
    @DisplayName("Should allocate vehicle")
    void shouldAllocateVehicle() throws WeightCapacityException, NoSpotException, VehicleTooTallException {

        var requestMock = VehicleDataDtoHelper.getVehicleDataDto();
        var responseMock = ParkingRegistryDtoHelper.getParkingRegistryDto();

        when(service.allocateVehicle(any(VehicleDataDto.class)))
                .thenReturn(responseMock);

        var response = controller.allocateVehicle(requestMock);

        assertEquals(responseMock, response.getBody());
    }

}