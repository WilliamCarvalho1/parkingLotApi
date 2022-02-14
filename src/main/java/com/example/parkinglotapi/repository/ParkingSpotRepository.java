package com.example.parkinglotapi.repository;

import com.example.parkinglotapi.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, String> {

    @Modifying
    @Query("UPDATE ParkingSpot ps SET free = false WHERE ps.id = ?1 ")
    void setParkingSpotToOccupied(long id);

}
