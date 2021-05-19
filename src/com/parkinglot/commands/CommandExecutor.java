package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.model.Command;
import com.parkinglot.service.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
