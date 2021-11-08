package com.example8.lectures;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();

        Course maths = new Course("матанализ",
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 31));

        Course philosophy = new Course("философия",
                Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 31));

        Course english = new Course("английкий язык",
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.FRIDAY),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 31));

        Course history = new Course("история",
                Arrays.asList(DayOfWeek.THURSDAY,  DayOfWeek.FRIDAY),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 31));

        Course physics = new Course("физкультура",
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 31));

        courses.add(maths);
        courses.add(philosophy);
        courses.add(english);
        courses.add(history);
        courses.add(physics);



        List<Lecture> lectures = courses.stream()
                .flatMap(course -> LectureFactory.generateLectures(course).stream())
                .collect(toList());

        List<Student> students = new ArrayList<>();
        students.add(new Student("Shadi"));
        students.add(new Student("Sofia"));
        students.add(new Student("Maria"));
        students.add(new Student("Alina"));
        students.add(new Student("Alexei"));
        students.add(new Student("Leonid"));
        students.add(new Student("Dmitri"));
        students.add(new Student("Ivan"));
        students.add(new Student("Artem"));
        students.add(new Student("Ekaterina"));

        simulateAttendance(lectures, students);

        attendedCourseAtLeastOnce(maths, students);

        studentAttendanceStats(students);

        courseWithMaxAttendance(students);

        attendedMaxLecturesADay(students);

        System.out.println("5. название курсов - количество разных студентов, которые посетили хотя бы одно занятие.");
        for (Course course : courses) {
            countStudentsAtLeastAttendedOnce(students, course);
        }

    }

    private static void attendedMaxLecturesADay(List<Student> students) {
        System.out.println("4. Имена студентов, которые посетили наибольшее количество лекций в день.");

        // Думаю не очень читабильно...
        Map.Entry<Long, List<Student>> longListEntry = students.stream()
                .collect(groupingBy(student -> student.getAttendedLectures().stream()
                        .collect(groupingBy(Lecture::getDate, counting()))
                        .values().stream().max(Comparator.comparingLong(value -> value)).orElse(0L)))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .orElse(new AbstractMap.SimpleEntry<>(0L, new ArrayList<>())); // in case of null


        System.out.printf("Кол-во лекции: %s - Студенты: %s%n", longListEntry.getKey(), longListEntry.getValue().stream().map(Student::getName).collect(toList()));
    }

    private static void simulateAttendance(List<Lecture> lectures, List<Student> students) {
        Random random = new Random();
        for (Student student : students) {
            for (Lecture lecture : lectures) {
                if (random.nextBoolean()) {
                    student.attendLecture(lecture);
                }
            }
        }
    }

    private static void countStudentsAtLeastAttendedOnce(List<Student> students, Course course) {
        Long studentsCount = students.stream()
                .filter(student -> student.getAttendedLectures().stream()
                        .anyMatch(lecture -> lecture.getName().equals(course.getName())))
                .count();
        System.out.printf("%s - %s %n", course.getName(), studentsCount);
    }

    private static void courseWithMaxAttendance(List<Student> students) {
        Map<String, Long> lecturesStats = students.stream()
                .flatMap(student -> student.getAttendedLectures().stream())
                .collect(groupingBy(Lecture::getName, counting()));

        Optional<Map.Entry<String, Long>> max = lecturesStats.entrySet().stream().max(Map.Entry.comparingByValue());

        System.out.println("3. Названия дисциплины, имеющих наибольшее количество посещений");
        if (max.isPresent()) {
            Map.Entry<String, Long> entry = max.get();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void studentAttendanceStats(List<Student> students) {
        System.out.println("2. Статистику посещений для каждого студента");
        students.forEach(student -> System.out.printf("%s - %s %n", student.getName(), student.getAttendedLectures().size()));
    }

    private static void attendedCourseAtLeastOnce(Course course, List<Student> students) {
        List<String> studentsList = students.stream()
                .filter(student -> student.getAttendedLectures().stream()
                        .anyMatch(lecture -> lecture.getName().equals(course.getName())))
                .map(Student::getName)
                .collect(toList());

        System.out.println("1. Список студентов, которые хоть раз посещали " + course.getName());
        System.out.println(studentsList);
    }
}
