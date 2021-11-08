package lections;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StudingStatistics {
    private final List<Student> students;

    public StudingStatistics(List<Student> students) {
        this.students = students;
    }

    public void printStudentsVisitedAtOnce(String lectionName){
        System.out.println("Список студентов, хоть посещавших "+lectionName+":");
        List<String> result = students.stream()
                .filter(student -> containsLectionName(student, lectionName))
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public void printQuantityVisits(){
        List<String> result = students.stream()
                .map(student -> student.getName() + " - " + student.getLections().size())
                .collect(Collectors.toList());

        System.out.println("Статистика посещений для каждого студентам:");
        for(String string: result){
            System.out.println(string);
        }
    }

    public void printLectionsNamesMaxVisites(){
        System.out.println("Название дисциплин, имеющих наибольшее количество посещений:");
        Map<String, Long> lectionsCountVisited = lectionsCountVisited();
        Optional<Map.Entry<String, Long>> maxValue = lectionsCountVisited.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if(maxValue.isPresent()){
            Set<String> lectionsNames = lectionsCountVisited.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxValue.get().getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
            System.out.printf("Максимальное количество посещений: %s , лекции: %s\n", maxValue.get().getValue(), lectionsNames);

        }
    }

    public void printStudentsMaxVisites(){
        System.out.println("Имена студентов, которые посетили наибольшее количество лекций в день:");
        long maxVisitsPerDay = students.stream()
                .map(student -> maxVisitePerDay(student.getLections()))
                .max(Long::compareTo)
                .get();

        Set<String> studentsNames = students.stream()
                .filter(student -> maxVisitePerDay(student.getLections())==maxVisitsPerDay)
                .map(Student::getName)
                .collect(Collectors.toSet());

        System.out.printf("Максимальное количество посещений в день: %s , студенты: %s\n", maxVisitsPerDay, studentsNames);
    }

    public void printCountStudentForLections(){
        System.out.println("Cтатистика по курсам:");
        Set<String> lections = flatLections()
                .stream()
                .map(Lection::getName)
                .collect(Collectors.toSet());

        for(String lectionName: lections){
            long count = students.stream()
                    .filter(student -> student.getLections()
                            .stream()
                            .map(Lection::getName)
                            .collect(Collectors.toSet())
                            .contains(lectionName))
                    .count();
            System.out.printf("%s - %s\n", lectionName, count);
        }
    }

    private boolean containsLectionName(Student student, String lectionName){
        return student
                .getLections()
                .stream()
                .anyMatch(lection -> lection.getName().equals(lectionName));
    }

    private Map<String, Long> lectionsCountVisited(){
        return flatLections().stream()
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));
    }

    private List<Lection> flatLections(){
        return students.stream()
                .flatMap(student-> student.getLections().stream())
                .collect(Collectors.toList());
    }

    private long maxVisitePerDay(Set<Lection> lections){
        return maxVisitePerDay(getVisitesCountPerDay(lections));
    }

    private long maxVisitePerDay(Map<LocalDate, Long> map){
        return map.values().stream()
                .max(Long::compareTo)
                .get();
    }

    private Map<LocalDate, Long> getVisitesCountPerDay(Set<Lection> lections){
        return lections.stream()
                .collect(Collectors.groupingBy(Lection::getDate, Collectors.counting()));
    }
}
