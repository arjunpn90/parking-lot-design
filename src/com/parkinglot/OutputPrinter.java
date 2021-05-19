package com.parkinglot;

public class OutputPrinter {

    public void welcome() {
        printWithNewLine("Welcome to Arjun's parking lot.");
    }

    public void createParkingCreated(int capacity) {
        printWithNewLine("New parking lot created with capacity - " + capacity);
    }

    public void exit() {
        printWithNewLine("Thank you for using Arjun's parking lot.");
    }

    public void parkingLotEmpty() {
        System.out.println("Parking lot is empty.");
    }

    public void statusHeader() {
        printWithNewLine("Slot No.    Registration No    Colour");
    }

    public void printWithNewLine(String message) {
        System.out.println(message);
    }
}
