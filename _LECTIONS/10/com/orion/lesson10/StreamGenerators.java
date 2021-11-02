package com.orion.lesson10;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamGenerators {


    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        ;

        System.out.println(Stream.generate(() -> integer.incrementAndGet())
                .dropWhile(e -> e.intValue() < 5)
                .takeWhile(e -> e.intValue() < 10)
                .mapToInt(i -> i.intValue())
                .sum());

/*

        LocalDate start = LocalDate.of(2021, 10, 1);
        LocalDate end = LocalDate.of(2021, 12, 31);

        Stream.iterate(start, currentDate -> currentDate.plusDays(1))
                .takeWhile(date -> date.isBefore(end))
                .forEach(date -> System.out.println(date));
*/

    }
}
