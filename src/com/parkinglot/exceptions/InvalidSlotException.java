package com.parkinglot.exceptions;

public class InvalidSlotException extends ParkingLotException {

    public InvalidSlotException() {
    }

    public InvalidSlotException(String message) {
        super(message);
    }
}
