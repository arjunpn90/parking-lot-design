package com.parkinglot.model;

import com.parkinglot.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final String SPACE = " ";
    private String commandName;
    private List<String> params;

    public Command(String inputLine) {
        List<String> tokens = Arrays.stream(inputLine.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokens.size() == 0)
            throw new InvalidCommandException();

        this.commandName = tokens.get(0);
        tokens.remove(0);
        this.params = tokens;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public List<String> getParams() {
        return this.params;
    }
}
