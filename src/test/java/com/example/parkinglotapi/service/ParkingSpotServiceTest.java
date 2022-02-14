package com.example.parkinglotapi.service;

import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.helper.ParkingSpotHelper;
import com.example.parkinglotapi.repository.ParkingSpotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingSpotServiceTest {

    @InjectMocks
    private ParkingSpotService parkingSpotService;

    @Mock
    private FloorService floorService;

    @Mock
    ParkingSpotRepository parkingSpotRepository;

    @Test
    public void shouldGetParkingSpot() throws NoSpotException {

        var expectedParkingSpot = ParkingSpotHelper.getParkingSpot();

        var parkingSportList = ParkingSpotHelper.getParkingSpotList();

        when(parkingSpotRepository.findAll())
                .thenReturn(parkingSportList);

        var actualParkingSpot = parkingSpotService.getParkingSpot(1L, new BigDecimal("500"));

        assertEquals(expectedParkingSpot.getId(), actualParkingSpot.getId());
    }

}