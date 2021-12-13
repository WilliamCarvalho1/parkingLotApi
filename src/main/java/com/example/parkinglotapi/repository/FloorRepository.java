package com.example.parkinglotapi.repository;

import com.example.parkinglotapi.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface FloorRepository extends JpaRepository<Floor, String> {

    @Modifying
    @Query("UPDATE Floor f SET current_weight_capacity = current_weight_capacity - ?1 WHERE f.id = ?2 ")
    void updateFloorWeightCapacity(BigDecimal vehicleWeight, long id);

    Floor findById(Long id);

}
