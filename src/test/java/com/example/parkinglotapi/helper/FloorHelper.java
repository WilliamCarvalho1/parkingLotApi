package com.example.parkinglotapi.helper;

import com.example.parkinglotapi.model.Floor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FloorHelper {
    public static Floor getFloor() {

        var floor = new Floor();

        floor.setId(1L);
        floor.setName("ground");
        floor.setWeightCapacity(new BigDecimal("200000"));
        floor.setCeilingHeight(new BigDecimal("4"));
        floor.setCurrentWeightCapacity(new BigDecimal("200000"));
        floor.setSpotQuantity(30);

        return floor;
    }

    public static List<Floor> getFloorList() {
        List<Floor> floorList = new ArrayList<>(0);

        var floor1 = new Floor();
        floor1.setId(1L);
        floor1.setName("ground");
        floor1.setWeightCapacity(new BigDecimal("200000"));
        floor1.setCeilingHeight(new BigDecimal("4"));
        floor1.setCurrentWeightCapacity(new BigDecimal("200000"));
        floor1.setSpotQuantity(30);

        var floor2 = new Floor();
        floor2.setId(2L);
        floor2.setName("first");
        floor2.setWeightCapacity(new BigDecimal("10000"));
        floor2.setCeilingHeight(new BigDecimal("1.80"));
        floor2.setCurrentWeightCapacity(new BigDecimal("10000"));
        floor2.setSpotQuantity(50);

        var floor3 = new Floor();
        floor3.setId(3L);
        floor3.setName("second");
        floor3.setWeightCapacity(new BigDecimal("10000"));
        floor3.setCeilingHeight(new BigDecimal("1.6"));
        floor3.setCurrentWeightCapacity(new BigDecimal("10000"));
        floor3.setSpotQuantity(50);

        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);

        return floorList;
    }

}
