package com.parkinglot.exceptions;

public class AlreadyOccupiedSlotException extends ParkingLotException {

    public AlreadyOccupiedSlotException() {
    }

    public AlreadyOccupiedSlotException(String message) {
        super(message);
    }
}
