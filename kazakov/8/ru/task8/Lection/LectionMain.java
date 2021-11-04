package ru.task8.Lection;

import java.sql.Struct;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static ru.task8.Lection.Discipline.*;

public class LectionMain {

    static class Person {
        public String name;
        public String profession;

        public Person(String name, String profession) {
            this.name = name;
            this.profession = profession;
        }

        public String getName() {
            return name;
        }

        public String getProfession() {
            return profession;
        }
    }

    public static void main(String[] args) {

        /*
        Создайте List<Student> students и заполните его 10 студентами, которые посетили 5 разных курсов
         (матанализ,философия, английкий язык, история, физкультура).
        Количество посещений придумайте самостоятельно.
         */
        //   (матанализ, философия, английкий язык, история, физкультура) {
        List<Student> studentsFaculty = new ArrayList<>(Arrays.asList(new Student("Вася"), new Student("Пётр"), new Student("Ян"),
                new Student("Мария"), new Student("Вика"), new Student("Софи"), new Student("Ксю"),
                new Student("Тоха"), new Student("Dave"), new Student("Олег"), new Student("Дэн"),
                new Student("Евг"), new Student("Вит")));
        //  нас интересуют пока только лекции на сегодня:
        studentsFaculty.forEach(s -> s.feedWithLections(LocalDate.now()));
        //studentsFaculty.forEach(Student::DumpLections);

        //  Теперь проведем аналитику:
        //  Для всех заданий используй students.stream() и операции с потоками.
        //  1. Выведите список студентов, которые хоть раз посещали матанализ.
        System.out.println("--- список студентов, которые хоть раз посещали матанализ ---");
        studentsFaculty.stream()
            .filter(s -> {
                for (Lection lection : s.getLections())
                    if (lection.getDiscipline().equals(MATH))
                        return true;
                return false;
                })
            .collect(Collectors.toList())
            .forEach(x -> System.out.println(x.getName()));

        //  2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.
        System.out.println("--- имя - количество посщенных лекций: ---");
        studentsFaculty.stream()
            .collect(groupingBy(Student::getName, Collectors.summingLong(s -> s.getLections().size())))
            .forEach((k,v)->System.out.println(k + " - посетил лекций: " + v));

        //  3. Выведите название дисциплин, имеющих наибольшее количество посещений.
        //  Если два разных студента посещают одну лекцию в один день, то это считается как два посещения.
        //  ===  ПОКА СДЕЛАЛ РЕШЕНИЕ ОБЫЧНЫМ ЦИКЛОМ: ===
        System.out.println("--- дисциплины, имеющие наибольшее количество посещений: ---");
        final Map<Discipline, Integer> discAttend = new HashMap<>();
        int count;
        for (Discipline disc : Discipline.values()) {
            count = 0;
            for (Student student : studentsFaculty) {
                for (Lection lection : student.getLections()) {
                    if (lection.getDiscipline().equals(disc)) {
                        count++;
                    }
                }
            }
            discAttend.put(disc, count);
        }
        discAttend.entrySet().stream()
                .sorted(Map.Entry.<Discipline, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        //  4. Выведите имена студентов, которые посетили наибольшее количество лекций в день
        System.out.println("--- студенты, которые посетили наибольшее количество лекций в день: ---");
            studentsFaculty.stream()
                .sorted(Comparator.comparing(s -> s.getLections().size(), Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .forEach(x-> System.out.printf("%s посетил: %d лекций\n", x.getName(), x.getLections().size())); //output 2 6 10 14

       //   5. Выведите статистику по курсам в формате:
       //    название курсов - количество разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучшем случае это будет 10)
        //  ===  ПОКА СДЕЛАЛ РЕШЕНИЕ ОБЫЧНЫМ ЦИКЛОМ: ===
        System.out.println("---  название курсов - количество разных студентов, которые посетили хотя бы одно занятие: ---");
        final Map<Discipline, Integer> discStudents = new HashMap<>();
        int cnt;
        for (Discipline disc : Discipline.values()) {
            cnt = 0;
            for (Student student : studentsFaculty) {
                for (Lection lection : student.getLections()) {
                    if (lection.getDiscipline().equals(disc)) {
                        cnt++;
                    }
                }
            }
            discStudents.put(disc, cnt);
        }
        discStudents.entrySet().stream()
                .forEach(System.out::println);
    }
}
