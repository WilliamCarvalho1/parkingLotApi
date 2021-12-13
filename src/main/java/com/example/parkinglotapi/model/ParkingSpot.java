package com.example.parkinglotapi.model;

import com.example.parkinglotapi.enums.ParkingSpotType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "parking_spot")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean free;

    @Enumerated(EnumType.STRING)
    private ParkingSpotType type;

    @Column(name = "floor_id")
    private Long floorId;

}
