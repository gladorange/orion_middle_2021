package com.orion.lesson10;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.stream.Stream;

public class ReadZip {


    public static void main(String[] args) throws IOException {
        final FileSystem fileSystem = FileSystems.newFileSystem(Paths.get("_LECTIONS/10/sample.zip"));

        try (Stream<Path> list = Files.list(fileSystem.getPath("/"))) {
            list.forEach(p -> {
                try {
                    accept(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void accept(Path p) throws IOException {
        final Path rootExtracted = Paths.get("extracted");
        Files.createDirectories(rootExtracted);
        if (p.toString().endsWith("txt")){
            Files.copy(p, rootExtracted.resolve(p.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
        }
        System.out.println(p.toString());
    }
}
