package com.example8.lectures;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Course {
    private String name;
    private List<DayOfWeek> daysOfWeek;
    private LocalDate start;
    private LocalDate end;

    public Course(String name, List<DayOfWeek> daysOfWeek, LocalDate start, LocalDate end) {
        this.name = name;
        this.daysOfWeek = daysOfWeek;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equals(course.name) && Objects.equals(daysOfWeek, course.daysOfWeek) && start.equals(course.start) && end.equals(course.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, daysOfWeek, start, end);
    }
}
