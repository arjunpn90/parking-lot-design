package com.parkinglot.exceptions;

public class InvalidCommandException extends ParkingLotException {

    public InvalidCommandException() {

    }

    public InvalidCommandException(String message) {
        super(message);
    }
}
