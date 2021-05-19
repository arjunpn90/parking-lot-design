package com.parkinglot.commands;

import com.parkinglot.OutputPrinter;
import com.parkinglot.exceptions.ParkingLotException;
import com.parkinglot.model.Car;
import com.parkinglot.model.Command;
import com.parkinglot.model.Slot;
import com.parkinglot.model.parking.strategy.NaturalOrderParkingStrategy;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.validators.IntegerValidator;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "status";

    public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    public boolean validate(Command command) {
        return command.getParams().size() == 0;
    }

    public void execute(Command command) {
        try {
            parkingLotService.validateParkingLotExists();
            List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
            if (occupiedSlots.isEmpty()) {
                outputPrinter.parkingLotEmpty();
                return;
            }

            outputPrinter.statusHeader();
            for (Slot slot : occupiedSlots) {
                final Car car = slot.getParkedCar();
                outputPrinter.printWithNewLine(padString(slot.getSlotNumber().toString(), 12) + padString(car.getRegistrationNumber(), 19) + car.getColor());
            }
        } catch (ParkingLotException ex) {
            outputPrinter.printWithNewLine(ex.getMessage());
        }
    }

    private String padString(String word, int padLength) {
        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = 0; i < padLength - word.length(); i++) {
            wordBuilder.append(" ");
        }
        return wordBuilder.toString();
    }
}
