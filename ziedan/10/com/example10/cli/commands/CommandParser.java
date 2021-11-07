package com.example10.cli.commands;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    public static CliCommand parse(String line) throws IllegalArgumentException {
        List<String> splittedLine = Arrays.asList(line.split(" "));
        String command = splittedLine.get(0);
        List<String> args = splittedLine.subList(1, splittedLine.size());

        switch (command) {
            case "ls":
                return new ListCommand(args);
            case "cd":
                return new ChangeDirectory(args);
            case "touch":
                return new TouchCommand(args);
            case "cat":
                return new CatCommand(args);
            case "rm":
                return new DeleteCommand(args);
            case "exit":
                return new ExitCommand();
            default:
                throw new IllegalArgumentException("Unknown command " + command);
        }
    }
}
