package lection8.task3;

import java.util.*;

public class Student {
    final private String name;
    private Set<Lection> attendedLections = new HashSet<>();

    public Student(String name, List<Lection> lections) {
        this.name = name;
        attendLections(lections);
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getAttendedLections() {
        return attendedLections;
    }

    private void attendLections(List<Lection> lections){
        Random random = new Random();
        for (Lection lection: lections) {
            if(random.nextBoolean())
                attendedLections.add(lection);
        }
    }

    @Override
    public String toString() {
        return "\n{Студент " +
                name +
                " посетил лекции:" + attendedLections +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && attendedLections.equals(student.attendedLections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attendedLections);
    }
}
