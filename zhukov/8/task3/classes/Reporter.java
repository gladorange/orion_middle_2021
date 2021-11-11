package task3.classes;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Reporter {

    public static void evenOnlyOneVisitLecture(String lectureName, @NotNull List<Student> students){
        Map<Set<Lection>,List<Student>> m =  students.stream()
                .collect(Collectors.groupingBy(Student::getVisitedLectures));
        System.out.print(m);


    }
}
