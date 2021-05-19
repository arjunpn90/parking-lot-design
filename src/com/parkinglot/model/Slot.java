package com.parkinglot.model;

public class Slot {
    private int slotNumber;
    private Car parkedCar;

    public Slot(final int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isSlotFree() {
        return this.parkedCar == null;
    }

    public void assignCar(final Car car) {
        this.parkedCar = car;
    }

    public void unassignCar() {
        this.parkedCar = null;
    }

    public Car getParkedCar() {
        return this.parkedCar;
    }

    public Integer getSlotNumber() {
        return this.slotNumber;
    }
}
