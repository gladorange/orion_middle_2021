package com.example10.cli.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DeleteCommand extends CliCommand {
    public DeleteCommand(List<String> args) {
        super(args);
    }


    @Override
    public void run() {
        try {
            Files.deleteIfExists(Console.currentPath.resolve(args.get(0)));
        } catch (IOException e) {
            System.out.printf("Error: %s %n", e.getMessage());
        }
    }
}
