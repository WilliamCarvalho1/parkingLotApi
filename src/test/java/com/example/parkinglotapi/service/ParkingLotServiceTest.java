package com.example.parkinglotapi.service;

import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.helper.FloorHelper;
import com.example.parkinglotapi.helper.ParkingRegistryDtoHelper;
import com.example.parkinglotapi.helper.ParkingSpotHelper;
import com.example.parkinglotapi.helper.VehicleDataDtoHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingLotServiceTest {

    @InjectMocks
    private ParkingLotService parkingLotService;

    @Mock
    private FloorService floorService;

    @Mock
    private ParkingSpotService parkingSpotService;

    @Mock
    private ParkingRegistryService parkingRegistryService;

    @Test
    void shouldAllocateVehicle() throws WeightCapacityException, VehicleTooTallException, NoSpotException {

        var response = ParkingRegistryDtoHelper.getParkingRegistryDto();

        var floor = FloorHelper.getFloor();

        when(floorService.getSuitableFloor(any(), any()))
                .thenReturn(floor);

        var parkingSpot = ParkingSpotHelper.getParkingSpot();

        when(parkingSpotService.getParkingSpot(anyLong(), any()))
                .thenReturn(parkingSpot);

        when(parkingRegistryService.createParkingRegistry(parkingSpot, floor.getName()))
                .thenReturn(response);

        var parkingLotRegistry = parkingLotService.allocateVehicle(VehicleDataDtoHelper.getVehicleDataDto());

        assertEquals(parkingLotRegistry, response);
    }

}