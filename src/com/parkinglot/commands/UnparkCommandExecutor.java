package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.exceptions.ParkingLotException;
import com.parkinglot.model.Command;
import com.parkinglot.model.parking.strategy.NaturalOrderParkingStrategy;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.validators.IntegerValidator;

public class UnparkCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "unpark";

    public UnparkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    public boolean validate(Command command) {
        return command.getParams().size() == 1 && IntegerValidator.validate(command.getParams().get(0));
    }

    public void execute(Command command) {
        try {
            parkingLotService.validateParkingLotExists();
            int slotNumber = Integer.parseInt(command.getParams().get(0));
            parkingLotService.leaveParkingLot(slotNumber);
            outputPrinter.printWithNewLine(String.format("Slot - {%d} is free now.", slotNumber));
        } catch (ParkingLotException ex) {
            outputPrinter.printWithNewLine(ex.getMessage());
        }
    }
}
