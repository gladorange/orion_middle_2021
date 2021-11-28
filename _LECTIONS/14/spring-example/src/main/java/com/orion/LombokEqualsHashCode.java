package com.orion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

public class LombokEqualsHashCode {


    @RequiredArgsConstructor
    @Getter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Animal {
        @EqualsAndHashCode.Include
        final String name;

        int age = new Random().nextInt(100);
    }

    public static void main(String[] args) {

        Animal sharik = new Animal("Sharik");
        Animal sharik2 = new Animal("Sharik");
        System.out.println(sharik.equals(sharik2));


        String fileContent = readFile("test.txt");
        System.out.println(fileContent);

    }

    @SneakyThrows
    private static String readFile(String s)  {
        return new String(Files.readAllBytes(Paths.get(s)));
    }
}
