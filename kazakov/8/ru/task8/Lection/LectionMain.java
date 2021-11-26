package ru.task8.Lection;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static ru.task8.Lection.Discipline.MATH;

public class LectionMain {

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

        /*
        //  Теперь проведем аналитику:
        //  Для всех заданий используй students.stream() и операции с потоками.
        //  1. Выведите список студентов, которые хоть раз посещали матанализ.
        Я говорил на лекции, что со стримами удобнее работать, если все операции внутри стрима вынести в отдельный метод
        здесь можно использовать s.getLections.stream.anyMatch Лекция №8
        ...
        смысла в collect() сразу перед forEach особого нет, можно вызвать forEach на стриме с тем же результатом.
        */
        System.out.println("--- 1. список студентов, которые хоть раз посещали матанализ ---");
         studentsFaculty.stream()
                .filter(s -> s.getLections().stream().anyMatch(l->l.getDiscipline().equals(MATH)))
                .forEach(x -> System.out.println(x.getName()));

        /*
         *  2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.
        Это было задание-ловушка :) Можно было бы сделать проще так:
        studentsFaculty.forEach(s -> print(s.name + " " + s.getLections().size))        */
        System.out.println("--- 2. имя - количество посщенных лекций: ---");
        studentsFaculty.forEach(s -> System.out.println(s.getName() + ": " + s.getLections().size()));

        /*  3. Выведите название дисциплин, имеющих наибольшее количество посещений.
         *  Если два разных студента посещают одну лекцию в один день, то это считается как два посещения.
         * (Можно было бы сделать через flatMap и группировку.)
         */
        System.out.println("--- 3. дисциплины, имеющие наибольшее количество посещений: ---");
        Map<Discipline, Long> disciplinesAttended = studentsFaculty.stream()
                .flatMap(student -> student.getLections().stream())
                .collect(groupingBy(Lection::getDiscipline, Collectors.counting()));

        Long discAttendsAndThen = studentsFaculty.stream()
                .flatMap(student -> student.getLections().stream())
                .collect(Collectors.collectingAndThen(groupingBy(Lection::getDiscipline, Collectors.counting()),
                        attends -> Collections.max(attends.values())));
        //disciplinesAttended.forEach((x, y) -> System.out.printf("%s %s\n", x.getName(), y));

        //  фильтруем и выводим дисциплины имеющие максимальное кол-во посещений:
        disciplinesAttended.entrySet().stream()
                .filter(entry -> entry.getValue().equals(discAttendsAndThen))
                .forEach(System.out::println);


        /*
        //  4. Выведите имена студентов, которые посетили наибольшее количество лекций в день
         */
        System.out.println("--- 4. имена студентов, которые посетили наибольшее количество лекций в день: ---");

        Long maxAttendsInDay = studentsFaculty.stream()
                .map(student -> maxAttends(student.getLections()))
                .max(Long::compareTo)
                .orElse(null);

        List<String> students = studentsFaculty.stream()
                .filter(student -> maxAttends(student.getLections()).equals(maxAttendsInDay))
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.printf("Студенты: %s посетили в день max кол-во лекций: %d\n", students, maxAttendsInDay);

        /*
        //   5. Выведите статистику по курсам в формате:
        //    название курсов - имена разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучшем случае это будет 10)
        //  набор всех лекций (дисциплин):
         */
        System.out.println("--- 5. названия курсов - имена студентов, посетивших  хотя бы одно занятие: ---");
        Set<Discipline> disciplines =
                studentsFaculty.stream()
                        .flatMap(student -> student.getLections().stream().map(Lection::getDiscipline))
                        .collect(Collectors.toSet());

        final Map<Discipline, List<String>> studensOnDiscipline = new HashMap<>();
        for (Discipline discipline : disciplines) {
            List<String> students2 =
            studentsFaculty.stream()
                    .filter(s -> s.getLections().stream().anyMatch(l -> l.getDiscipline().equals(discipline)))
                    .map(Student::getName)
                    .collect(Collectors.toList());
            studensOnDiscipline.put(discipline, students2);
        }
        studensOnDiscipline.forEach((x, y) ->  System.out.printf("%s %s\n", x.getName(), y));
    }

    private static Long maxAttends(Set<Lection> lections) {
        return lections.stream()
                .collect(Collectors.collectingAndThen(
                        groupingBy(Lection::getEventDate, Collectors.counting()),
                        attends -> Collections.max(attends.values())));
    }
}

