package com.example10.cli.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ChangeDirectory extends CliCommand {

    public ChangeDirectory(List<String> args) {
        super(args);
        this.args = args;
    }

    @Override
    public void run() {
        Path resolvedPath = Console.currentPath.resolve(args.get(0));
        if (!Files.exists(resolvedPath) || !Files.isDirectory(resolvedPath)) {
            System.out.println("Invalid directory");
            return;
        }
        Console.currentPath = resolvedPath;
    }
}
