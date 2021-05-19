package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.exceptions.ParkingLotException;
import com.parkinglot.model.Car;
import com.parkinglot.model.Command;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Slot;
import com.parkinglot.model.parking.strategy.NaturalOrderParkingStrategy;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.validators.IntegerValidator;

public class ParkCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    public void execute(Command command) {
        try {
            parkingLotService.validateParkingLotExists();
            String registrationNumber = command.getParams().get(0);
            String color = command.getParams().get(1);
            Car car = new Car(registrationNumber, color);
            Slot slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Car parked at slot - " + slot.getSlotNumber());
        } catch (ParkingLotException ex) {
            outputPrinter.printWithNewLine(ex.getMessage());
        }
    }
}
