package com.example.parkinglotapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@Table(name = "parking_registry")
public class ParkingRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_time")
    private String initialTime;

    @Column(name = "parking_spot_id")
    private Long parkingSpotId;

    @Column(name = "floor_name")
    private String floorName;

    @Column(name = "price_per_minute")
    private BigDecimal pricePerMinute;

}
