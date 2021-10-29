package com.orion.lesson9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeApiExample {


    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);


        LocalDate today = LocalDate.of(2021, 10, 28);
        System.out.println(today);

        LocalDate anotherToday = LocalDate.of(2021, Month.OCTOBER, 28);

        final LocalDate twoMonthLater = anotherToday.plusMonths(2);
        System.out.println(twoMonthLater);


        System.out.println(twoMonthLater.compareTo(twoMonthLater) >= 0);


        System.out.println(anotherToday.atStartOfDay());
        System.out.println(anotherToday.atTime(18, 31));


        final LocalDate dayOfProgrammer = anotherToday.withDayOfYear(256);
        System.out.println(dayOfProgrammer);

        System.out.println(anotherToday.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(anotherToday.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth()));


        LocalDate start = LocalDate.of(2021, 1, 1);
        LocalDate end = LocalDate.of(2021, 10, 28);
        final Period period = Period.between(start, end);
        System.out.println(period.getDays());


        final long between = ChronoUnit.DAYS.between(start.atStartOfDay(), end.atStartOfDay());
        System.out.println(between);


        System.out.println(start);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy HH:mm");
        System.out.println(formatter.format(start.atStartOfDay()));


        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();




        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);


    }
}
