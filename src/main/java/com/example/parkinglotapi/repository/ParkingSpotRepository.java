package com.example.parkinglotapi.repository;

import com.example.parkinglotapi.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, String> {

    @Query(value = "SELECT ps.id, ps.free, ps.type, ps.floor_id " +
            "FROM parking_spot ps " +
            "INNER JOIN floor f " +
            "ON ps.floor_id = f.id " +
            "WHERE ps.free = true " +
            "AND f.ceiling_height >= :vehicleHeight " +
            "AND f.current_weight_capacity >= :vehicleWeight " +
            "ORDER BY f.ceiling_height " +
            "LIMIT 1", nativeQuery = true)
    ParkingSpot getAvailableParkingSpot(@Param("vehicleHeight") BigDecimal vehicleHeight, @Param("vehicleWeight") BigDecimal vehicleWeight);

    @Modifying
    @Query("UPDATE ParkingSpot ps SET free = false WHERE ps.id = ?1 ")
    void setParkingSpotToOccupied(long id);

}
