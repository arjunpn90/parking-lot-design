package com.parkinglot.exceptions;

public class NoFreeSlotAvailableException extends ParkingLotException {

    public NoFreeSlotAvailableException() {

    }

    public NoFreeSlotAvailableException(String message) {
        super(message);
    }
}