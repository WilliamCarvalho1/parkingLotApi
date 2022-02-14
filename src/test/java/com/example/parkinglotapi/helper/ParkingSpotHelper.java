package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.enums.ParkingSpotType;
import com.example.parkinglotapi.model.ParkingSpot;

public class ParkingSpotHelper {
    public static ParkingSpot getParkingSpot() {

        var parkingSpot = new ParkingSpot();

        parkingSpot.setId(1L);
        parkingSpot.setFloorId(1L);
        parkingSpot.setFree(true);
        parkingSpot.setType(ParkingSpotType.SMALL);

        return parkingSpot;

    }
}
