package com.parkinglot.service;

import com.parkinglot.exceptions.ParkingLotException;
import com.parkinglot.model.Car;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Slot;
import com.parkinglot.model.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(int capacity, ParkingStrategy parkingStrategy) {
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= capacity; i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Slot park(Car car) {
        int slotNumber = parkingStrategy.getNextSlot();
        parkingStrategy.removeSlot(slotNumber);
        return parkingLot.parkCar(car, slotNumber);
    }

    public void leaveParkingLot(int slotNumber) {
        parkingLot.makeSlotFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public void validateParkingLotExists() {
        if (parkingLot == null)
            throw new ParkingLotException("Parking lot does not exist.");
    }

    public List<Slot> getOccupiedSlots() {
        List<Slot> occupiedSlots = new ArrayList<>();
        Map<Integer, Slot> allSlots = parkingLot.getAllSlots();
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            if (allSlots.containsKey(i)) {
                final Slot slot = allSlots.get(i);
                if (!slot.isSlotFree())
                    occupiedSlots.add(slot);
            }
        }
        return occupiedSlots;
    }
}
