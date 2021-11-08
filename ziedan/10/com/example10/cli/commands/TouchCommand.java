package com.example10.cli.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TouchCommand extends CliCommand {
    public TouchCommand(List<String> args) {
        super(args);
    }

    @Override
    public void run() {
        try {
            Path desiredPath = Console.currentPath.resolve(args.get(0));
            if (Files.exists(desiredPath)) {
                System.out.printf("File %s already exists%n", args.get(0));
                return;
            }
            Files.createFile(desiredPath);
        } catch (IOException e) {
            System.out.printf("Error while creating the file: %s %n", e.getMessage());
        }
    }
}
