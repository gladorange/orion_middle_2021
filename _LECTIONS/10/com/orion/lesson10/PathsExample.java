package com.orion.lesson10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsExample {


    public static void main(String[] args) {


        final Path testDir = Paths.get("test", "directory", "3rd level");
        System.out.println("dir:" + testDir);
        System.out.println("parent:" + testDir.getParent());
        System.out.println("sibling :" + testDir.resolve("children"));
    }
}
