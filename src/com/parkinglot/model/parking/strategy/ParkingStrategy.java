package com.parkinglot.model.parking.strategy;

import com.parkinglot.model.Slot;
import com.parkinglot.validators.IntegerValidator;

public interface ParkingStrategy {

    public void addSlot(Integer slotNumber);

    public void removeSlot(Integer slotNumber);

    public Integer getNextSlot();
}
