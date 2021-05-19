package com.parkinglot.model.parking.strategy;

import com.parkinglot.exceptions.NoFreeSlotAvailableException;
import com.parkinglot.model.Slot;

import java.util.TreeSet;

public class NaturalOrderParkingStrategy implements ParkingStrategy {
    TreeSet<Integer> slots;

    public NaturalOrderParkingStrategy() {
        this.slots = new TreeSet<>();
    }

    public void addSlot(Integer slotNumber) {
        this.slots.add(slotNumber);
    }

    public void removeSlot(Integer slotNumber) {
        this.slots.remove(slotNumber);
    }

    public Integer getNextSlot() {
        if (slots.isEmpty())
            throw new NoFreeSlotAvailableException("Parking lot is full.");
        return this.slots.first();
    }
}
