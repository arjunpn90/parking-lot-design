package com.parkinglot.model;

import com.parkinglot.exceptions.AlreadyOccupiedSlotException;
import com.parkinglot.exceptions.InvalidSlotException;
import com.parkinglot.exceptions.ParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int MAX_CAPACITY = 500;
    private int capacity;
    private Map<Integer, Slot> allShots;

    public ParkingLot(int capacity) {
        if (capacity <= 0 || capacity > MAX_CAPACITY)
            throw new ParkingLotException("Invalid parking lot capacity.");

        this.capacity = capacity;
        allShots = new HashMap<>();
    }

    public Slot getSlot(int slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException("Slot number is invalid.");
        }
        if (!allShots.containsKey(slotNumber))
            allShots.put(slotNumber, new Slot(slotNumber));
        return allShots.get(slotNumber);
    }

    public Map<Integer, Slot> getAllSlots() {
        return allShots;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public Slot parkCar(Car car, int slotNumber) {
        Slot slot = getSlot(slotNumber);
        if (!slot.isSlotFree())
            throw new AlreadyOccupiedSlotException("Slot is already occupied.");
        slot.assignCar(car);
        return slot;
    }

    public void makeSlotFree(int slotNumber) {
        Slot slot = getSlot(slotNumber);
        slot.unassignCar();
    }
}
