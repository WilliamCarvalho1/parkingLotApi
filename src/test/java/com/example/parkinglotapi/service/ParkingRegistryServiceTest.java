package com.example.parkinglotapi.service;

import com.example.parkinglotapi.helper.FloorHelper;
import com.example.parkinglotapi.helper.ParkingRegistryDtoHelper;
import com.example.parkinglotapi.helper.ParkingSpotHelper;
import com.example.parkinglotapi.repository.ParkingRegistryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ParkingRegistryServiceTest {

    @InjectMocks
    private ParkingRegistryService parkingRegistryService;

    @Mock
    private ParkingRegistryRepository parkingRegistryRepository;

    @Test
    public void shouldCreateParkingRegistry() {

        var expectedParkingRegistryDto = ParkingRegistryDtoHelper.getParkingRegistryDto();

        var parkingSpot = ParkingSpotHelper.getParkingSpot();

        var floor = FloorHelper.getFloor();

        var actualParkingSpotRegistryDto = parkingRegistryService.createParkingRegistry(
                parkingSpot, floor.getName());

        assertEquals(expectedParkingRegistryDto.getParkingSpotId(), actualParkingSpotRegistryDto.getParkingSpotId());

    }

}