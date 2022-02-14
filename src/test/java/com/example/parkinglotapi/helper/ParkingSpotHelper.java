package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.enums.ParkingSpotType;
import com.example.parkinglotapi.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotHelper {
    public static ParkingSpot getParkingSpot() {

        var parkingSpot = new ParkingSpot();
        parkingSpot.setId(1L);
        parkingSpot.setFloorId(1L);
        parkingSpot.setFree(true);
        parkingSpot.setType(ParkingSpotType.SMALL);

        return parkingSpot;

    }

    public static List<ParkingSpot> getParkingSpotList() {

        var parkingSpot1 = new ParkingSpot();
        parkingSpot1.setId(1L);
        parkingSpot1.setFloorId(1L);
        parkingSpot1.setFree(true);
        parkingSpot1.setType(ParkingSpotType.SMALL);

        var parkingSpot2 = new ParkingSpot();
        parkingSpot2.setId(2L);
        parkingSpot2.setFloorId(2L);
        parkingSpot2.setFree(true);
        parkingSpot2.setType(ParkingSpotType.MEDIUM);

        var parkingSpot3 = new ParkingSpot();
        parkingSpot3.setId(1L);
        parkingSpot3.setFloorId(1L);
        parkingSpot3.setFree(true);
        parkingSpot3.setType(ParkingSpotType.LARGE);

        List<ParkingSpot> parkingSpotList = new ArrayList<>(0);

        parkingSpotList.add(parkingSpot1);
        parkingSpotList.add(parkingSpot2);
        parkingSpotList.add(parkingSpot3);

        return parkingSpotList;

    }

}
