package com.parkinglot.validators;

public class IntegerValidator {
    public static boolean validate(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
