package task3.classes;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reporter {

    public static void evenOnlyOneLectureVisit(String lectureName,  List<Student> students){
        List<String> studentList = students.stream()
                .filter(studentWasOnLecture(lectureName))
                .map( student -> student.getName())
                .collect(Collectors.toList());

        System.out.printf("There were students %s on the lecture %s  ", studentList, lectureName);
    }


    private static Predicate<Student> studentWasOnLecture(String lectureName) {
        return student -> {
            Set<Lection> s =  student.getVisitedLectures();
            return s.stream().filter(o -> o.getTitle().equals(lectureName)).count() > 0;
        };
    }

    public static void studentsVisitStat(List<Student> students){
        Map<String,Integer> postsPerType = students.stream()
                .collect(Collectors.toMap(Student::getName,
                        Reporter::calculateUniqueLectures));
        System.out.print( postsPerType);
    }

    private static Integer calculateUniqueLectures(Student student) {
        return student.getVisitedLectures().stream()
                .map(lecture-> lecture.getTitle())
                .distinct()
                .collect(Collectors.toList()).size();
    }

    public static void maxVisitedLectures(List<Student> students) {
        Set<Lection> uniqueLectures  = new HashSet<>();
        students.stream()
                .map(student -> student.getVisitedLectures())
                .forEach(collection->collection.stream().forEach( lecture->uniqueLectures.add(lecture)  ));

        Map<String,Long> lectureVisits =  uniqueLectures.stream()
                .collect(Collectors.groupingBy(Lection::getTitle,Collectors.counting()));

        System.out.print("Max visits table:\n");

        lectureVisits.keySet().stream()
                    .filter( val -> lectureVisits.get(val) > 10 )
                    .sorted()
                    .forEach( e->  System.out.printf("%s %s \n",e,lectureVisits.get(e)));

        System.out.print(lectureVisits);
    }

    public static void maxVisitedStudents(LocalDate date , List<Student> students) {
        Map<String,Long> postsPerType = students.stream()
                .filter(student -> student.getVisitedLectures().stream().filter(lection -> lection.getDate().equals(date)).count() > 0)
                .collect(Collectors.toMap(Student::getName,student -> {
                    return calculateEventsToDay(date, student);
                })
        );
      System.out.print(postsPerType);

    }

    private static long calculateEventsToDay(LocalDate date, Student student) {
        return student.getVisitedLectures()
                .stream()
                .filter(lecture -> lecture.getDate().equals(date)).count();
    }

    public static void courseStatistic(List<Student> students) {
        Set<String> uniqueLectures  = new HashSet<>();
        students.stream()
                .map(student -> student.getVisitedLectures())
                .forEach(collection->collection.stream().forEach( lecture->uniqueLectures.add(lecture.getTitle())  ));

        uniqueLectures.stream().forEach(lectureTitle->{
            long s = students.stream()
                    .filter(student -> student.getVisitedLectures()
                            .stream().anyMatch( lecture->lecture.getTitle().equals(lectureTitle))
                    ).count();
            System.out.printf("There were %s students on %s \n",s, lectureTitle);
        });

    }
}
