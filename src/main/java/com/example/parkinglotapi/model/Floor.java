package com.example.parkinglotapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "weight_capacity")
    private BigDecimal weightCapacity;

    @Column(name = "ceiling_height")
    private BigDecimal ceilingHeight;

    @Column(name = "current_weight_capacity")
    private BigDecimal currentWeightCapacity;

    @Column(name = "spot_quantity")
    private int spotQuantity;

}
