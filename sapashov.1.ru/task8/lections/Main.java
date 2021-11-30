package task8.lections;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = createStudents();
        List<Lection> lections = createLections();
        visitLections(lections, students);


        //1. find a student visited a math
        System.out.println("students visited a math");
        List<Student> mathVisitedStudents = students.stream()
                .filter(student -> student.getLections().stream().anyMatch(lection -> lection.getName().equals("math")))
                .collect(Collectors.toList());
        mathVisitedStudents.forEach(System.out::println);

        //2. visits per student
        System.out.println("\nvisits per student");
        System.out.println(students.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.summarizingInt(value -> value.getLections().size())))
        );

        //3. lecture with the most amount of visits
        Map<String, Integer> visitedLectures = students.stream()
                .flatMap(student -> student.getLections().stream())
                .collect(Collectors.groupingBy(Lection::getName, Collectors.summingInt(x -> 1)));

        Optional<Integer> max = visitedLectures.values().stream().max(Integer::compareTo);
        System.out.println("Max: " + max.get());

        //4. Students name with the biggest amount of visits a day
        Map<String, Integer> nameAndMaxVisits = new HashMap<>();

        for (Student st : students) {
            Map<LocalDate, Integer> collect = st.getLections().stream()
                    .collect(Collectors.groupingBy(Lection::getTime, Collectors.summingInt(x -> 1)));

            Optional<Integer> maxV = collect.values().stream().max(Comparator.comparingInt(Integer::intValue));
            nameAndMaxVisits.put(st.getName(), maxV.get());
        }
        System.out.println("Max visits for each name " + nameAndMaxVisits);


        // statictics by course /название курсов - количество разных студентов
        Map<String, Set<String>> courseAndStudents = new HashMap<>();
        Map<String, Set<String>> lectAndStudents = new HashMap<>();
        Set<String> studentSet = new HashSet<>();

        for (Student st : students) {
            Map<String, List<Lection>> lectNameAndLections = st.getLections().stream().collect(Collectors.groupingBy(Lection::getName));
            Set<String> lectionType = lectNameAndLections.keySet();
            courseAndStudents.put(st.getName(), lectionType);
            for (String lect : lectionType) {
                studentSet.add(st.getName());
                lectAndStudents.put(lect, studentSet);
            }
        }


        System.out.println("======5======= " + lectAndStudents);
    }


    private static void visitLections(List<Lection> lections, List<Student> students) {
        for (Student student : students) {
            for (Lection lection : lections) {
                if (new Random().nextBoolean()) {
                    student.getLections().add(lection);
                }
            }
        }
    }

    private static List<Lection> createLections() {
        List<String> types = Arrays.asList("math", "philosophy", "english", "history", "phis");
        List<Integer> days = Arrays.asList(1, 2, 3, 5, 5);
        List<Lection> lections = new ArrayList<>();
        for (Integer day : days) {
            for (String type : types) {
                if (new Random().nextBoolean()) {
                    lections.add(new Lection(type, LocalDate.of(2021, Month.NOVEMBER, day)));
                }
            }
        }
        return lections;
    }

    private static List<Student> createStudents() {
        Student student1 = new Student("Vasya", new HashSet<>());
        Student student2 = new Student("Masha", new HashSet<>());
        Student student3 = new Student("Petya", new HashSet<>());
        Student student4 = new Student("Victor", new HashSet<>());
        Student student5 = new Student("Sasha", new HashSet<>());
        Student student6 = new Student("Andrey", new HashSet<>());
        Student student7 = new Student("Artem", new HashSet<>());
        Student student8 = new Student("Tanya", new HashSet<>());
        Student student9 = new Student("Natasha", new HashSet<>());
        Student student10 = new Student("Galya", new HashSet<>());

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);

        return studentList;
    }
}
