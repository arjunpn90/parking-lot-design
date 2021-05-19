package com.parkinglot;

import com.parkinglot.commands.CommandExecutor;
import com.parkinglot.commands.CommandExecutorFactory;
import com.parkinglot.commands.ExitParkingLotCommandExecutor;
import com.parkinglot.exceptions.InvalidCommandException;
import com.parkinglot.model.Command;
import com.parkinglot.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(final String[] args) throws IOException {
        OutputPrinter outputPrinter = new OutputPrinter();
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        outputPrinter.welcome();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            Command command = new Command(input);
            CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
            if (commandExecutor.validate(command)) {
                commandExecutor.execute(command);
            }
            else {
                outputPrinter.printWithNewLine("Invalid command.");
            }
            if (command.getCommandName().equals(ExitParkingLotCommandExecutor.COMMAND_NAME)) break;
        }
    }
}
