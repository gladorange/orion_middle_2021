package com.example10.cli.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CatCommand extends CliCommand {

    public CatCommand(List<String> args) {
        super(args);
    }

    @Override
    public void run() {
        if (!args.get(0).equals(">")) {
            Path path = Console.currentPath.resolve(args.get(0));
            try(Stream<String> lines = Files.lines(path)) {
                lines.forEach(System.out::println);
            } catch (IOException e) {
                System.out.printf("Error while reading the file: %s %n", e.getMessage());
            }
        } else {
            String nextLine;
            List<String> lines = new ArrayList<>();
            Path path = Console.currentPath.resolve(args.get(1));
            while (Console.scanner.hasNextLine() && !(nextLine = Console.scanner.nextLine()).equals("EOF")) {
                lines.add(nextLine);
            }
            try {
                Files.writeString(path, String.join("\n", lines));
            } catch (IOException e) {
                System.out.printf("Error while editing the file: %s%n", e.getMessage());
            }

        }
    }
}
