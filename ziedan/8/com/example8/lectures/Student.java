package com.example8.lectures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lecture> attendedLectures = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public void attendLecture(Lecture lecture) {
        attendedLectures.add(lecture);
    }

    public Set<Lecture> getAttendedLectures() {
        return attendedLectures;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
