package com.example.parkinglotapi.advice;

import com.example.parkinglotapi.exception.NoSpotException;
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

}
