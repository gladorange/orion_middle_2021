package lection8.task3;
//Домашнее задание к лекции 8
//Лямбда-выражения и потоки
//Потоковые лекции
//Салмов Евгений

import lection6.tuples.Pair;
import lection6.tuples.Triple;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class Task3 {
    final public static String[] COURSES = {"Матанализ","Философия", "Английкий язык", "История", "Физкультура"};
    final static String[] NAMES = {"Пётр","Виктор","Алексей","Леонид","Лена",
            "Александр","Владимир","Станислав","Алевтина","Марина"};
    final static int DAYS_QUANTITY = 5;

    public static void main(String[] args) {
        List<Lection> lections = createSchedule();
        System.out.println("Расписание лекций:\n"+lections+"\n");
        List<Student> students = createStudents(lections);
        System.out.println("Журнал посещаемости:\n"+students+"\n");
        matStudents(students);
        lectionsAttendCount(students);
        mostAttendedCourses(students);
        maxDayLectionsStudents(students);
        lectionsStudentsCount(students);
    }

    private static void matStudents(List<Student> students) {
        System.out.println("1. Список студентов, которые хоть раз посещали матанализ:");
        List<Student> matStudents = students.stream()
                .filter(s -> s.getAttendedLections().stream()
                        .anyMatch(l -> l.getName().equals("Матанализ")))
                .collect(Collectors.toList());
        for (Student student: matStudents) {
            System.out.println(student.getName());
        }
    }

    private static void lectionsAttendCount(List<Student> students) {
        System.out.println("\n2. Количество лекций, посещённых студентами:");
        System.out.println( students.stream()
                .collect(
                        groupingBy(Student::getName,
                                summingInt(s -> s.getAttendedLections().size()) )
                )
        );
    }

    private static void mostAttendedCourses(List<Student> students) {
        System.out.println("\nКоличество посещений по дисциплинам:");
        List<Lection> attendedLections = students.stream()
                .flatMap(s -> s.getAttendedLections().stream())
                .collect(Collectors.toList());
        final Map<String, Long> collect = attendedLections.stream()
                .collect(
                        groupingBy(Lection::getName,
                                counting()/*summingLong( l -> {return 1;})*/ )
                );
        System.out.println(
                collect
        );
        System.out.println("3. Названия дисциплин, имеющих наибольшее количество посещений:");
        System.out.println(
                collect.keySet().stream().filter(
                        l -> collect.get(l).equals( Collections.max(collect.values()) )
                ).collect(toList())
        );
    }

    private static void maxDayLectionsStudents(List<Student> students) {
        System.out.println("\n4. Имена студентов, которые посетили наибольшее количество лекций в день:");
        Map<String,Long> attendances = new HashMap<>();
        for (Student student: students) {
            final Map<LocalDate, Long> studentLections = student.getAttendedLections().stream()
                    .collect(
                            groupingBy(Lection::getLectionDate, counting())
                    );
            attendances.put(student.getName(),Collections.max(studentLections.values()));
        }
        System.out.println(
                attendances.keySet().stream()
                        .filter(
                                a->attendances.get(a).equals((Collections.max(attendances.values()))))
                        .collect(toList())
        );
    }

    private static void lectionsStudentsCount(List<Student> students) {
        Map<String,Long> courseStudents = new HashMap<>();
        for (String course: COURSES) {
            courseStudents.put(course, students.stream()
                    .filter(s -> s.getAttendedLections().stream()
                            .anyMatch(l -> l.getName().equals(course)))
                    .count());
        }
        System.out.println("\n5. Статистику по курсам в формате:");
        System.out.println("\"название курса - количество разных студентов, посетивших хотя бы одно занятие\":");
        courseStudents.keySet().stream()
                .forEach(k-> System.out.println(k + "-" + courseStudents.get(k)));
    }

    private static List<Student> createStudents(List<Lection> lections) {
        List<Student> students = new ArrayList<>();
        for (String name: NAMES) {
            students.add(new Student(name, lections));
        }
        return students;
    }

    private static List<Lection> createSchedule() {
        List<Lection> lections = new ArrayList<>();
        Random random = new Random();
        final int firstDay = 6;
        for (int i = 0; i < DAYS_QUANTITY; i++) {
            for (String course: COURSES) {
                if(random.nextBoolean())
                    lections.add(new Lection(course, LocalDate.of(2021, Month.SEPTEMBER, firstDay+i)) );
            }
        }
        return lections;
    }
}
