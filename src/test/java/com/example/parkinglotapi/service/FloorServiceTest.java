package com.example.parkinglotapi.service;

import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.helper.FloorHelper;
import com.example.parkinglotapi.repository.FloorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FloorServiceTest {

    @InjectMocks
    private FloorService floorService;

    @Mock
    FloorRepository floorRepository;

    @Test
    public void shouldGetSuitableFloor() throws VehicleTooTallException, WeightCapacityException {

        var expectedFloor = FloorHelper.getFloor();

        var floorList = FloorHelper.getFloorList();

        when(floorRepository.findAll())
                .thenReturn(floorList);

        var actualFloor = floorService.getSuitableFloor(new BigDecimal("1.90"), new BigDecimal("500"));

        assertEquals(expectedFloor.getId(), actualFloor.getId());
    }

    @Test
    public void shouldThrowVehicleTooTallException() {

        assertThrows(VehicleTooTallException.class, () -> {
            var floorList = FloorHelper.getFloorList();

            when(floorRepository.findAll())
                    .thenReturn(floorList);

            floorService.getSuitableFloor(new BigDecimal("5"), new BigDecimal("500"));
        });
    }

    @Test
    public void shouldThrowWeightCapacityException() {

        assertThrows(WeightCapacityException.class, () -> {
            var floorList = FloorHelper.getFloorList();

            when(floorRepository.findAll())
                    .thenReturn(floorList);

            floorService.getSuitableFloor(new BigDecimal("3"), new BigDecimal("500000000"));
        });
    }

}