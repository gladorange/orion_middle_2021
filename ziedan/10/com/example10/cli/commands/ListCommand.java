package com.example10.cli.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ListCommand extends CliCommand {

    public ListCommand(List<String> args) {
        super(args);
    }

    @Override
    public void run() {
        try {
            Files.list(Console.currentPath)
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
