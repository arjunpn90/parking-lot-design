package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.exceptions.InvalidCommandException;
import com.parkinglot.model.Command;
import com.parkinglot.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ExitParkingLotCommandExecutor.COMMAND_NAME,
                new ExitParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService, outputPrinter));
        commands.put(UnparkCommandExecutor.COMMAND_NAME,
                new UnparkCommandExecutor(parkingLotService, outputPrinter));
        commands.put(StatusCommandExecutor.COMMAND_NAME,
                new StatusCommandExecutor(parkingLotService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null)
            throw new InvalidCommandException();

        return commandExecutor;
    }
}
