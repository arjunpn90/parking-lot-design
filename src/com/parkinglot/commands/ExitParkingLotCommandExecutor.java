package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.model.Command;
import com.parkinglot.service.ParkingLotService;

public class ExitParkingLotCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "exit";

    public ExitParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    public boolean validate(Command command) {
        return command.getParams().size() == 0;
    }

    public void execute(Command command) {
        outputPrinter.exit();
    }
}
