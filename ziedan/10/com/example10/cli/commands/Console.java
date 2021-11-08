package com.example10.cli.commands;

import java.nio.file.Path;
import java.util.Scanner;

public class Console {
    public final static Scanner scanner;
    public static Path currentPath = Path.of("./").toAbsolutePath();

    static {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print(currentPath + "> ");
        CliCommand command;
        if (scanner.hasNextLine()) {
            try {
                command = CommandParser.parse(scanner.nextLine());
                if (command instanceof ExitCommand) {
                    return;
                }
                command.run();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new RuntimeException("Stream is somehow closed.");
        }
        start();
    }
}
