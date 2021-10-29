package com.orion.lesson8;

import java.util.stream.Stream;

public class SomethingMatchExample {


    public static void main(String[] args) {

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 7, 8, 9, 0)
                .anyMatch(in -> in / 2 != 0)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 7, 8, 9, 0)
                .allMatch(in -> in / 2 != 0)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 7, 8, 9, 0)
                .noneMatch(in -> in > 10)
        );


    }
}
