package com.example8.lectures;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class LectureFactory {

    public static List<Lecture> generateLectures(Course course) {

        List<Lecture> lectures = new ArrayList<>();

        Stream.iterate(course.getStart(), d -> d.plusDays(1))
                .limit(ChronoUnit.DAYS.between(course.getStart().atStartOfDay(), course.getEnd().plusDays(1).atStartOfDay()))
                .filter(d -> course.getDaysOfWeek().contains(d.getDayOfWeek()))
                .forEach(d -> lectures.add(new Lecture(course.getName(), d)));

        return lectures;
    }
}
