package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.exceptions.ParkingLotException;
import com.parkinglot.model.Command;
import com.parkinglot.model.parking.strategy.NaturalOrderParkingStrategy;
import com.parkinglot.model.parking.strategy.ParkingStrategy;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.validators.IntegerValidator;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    public boolean validate(Command command) {
        return command.getParams().size() == 1 && IntegerValidator.validate(command.getParams().get(0));
    }

    public void execute(Command command) {
        try {
            int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
            parkingLotService.createParkingLot(parkingLotCapacity, new NaturalOrderParkingStrategy());
            outputPrinter.createParkingCreated(parkingLotCapacity);
        } catch (ParkingLotException ex) {
            outputPrinter.printWithNewLine(ex.getMessage());
        }
    }
}
