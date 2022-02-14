package com.example.parkinglotapi.advice;

import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ParkingLotControllerAdvice {

    @ExceptionHandler(NoSpotException.class)
    public ResponseEntity<String> handleNoSpotException(NoSpotException notSpotException) {
        return new ResponseEntity<>("There's no Parking Spots available at this moment.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleTooTallException.class)
    public ResponseEntity<String> handleCustomBadRequestException(VehicleTooTallException vehicleTooTallException) {
        return new ResponseEntity<>("Vehicle is too tall to fit in our parking lot.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeightCapacityException.class)
    public ResponseEntity<String> handleWeightCapacityException(WeightCapacityException weightCapacityException) {
        return new ResponseEntity<>("Sorry! Our parking lot has reached its maximum weight capacity.", HttpStatus.NOT_FOUND);
    }

}
