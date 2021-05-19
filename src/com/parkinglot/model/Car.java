package com.parkinglot.model;

public class Car {
    private String registrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
