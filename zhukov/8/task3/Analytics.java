package task3;

import task3.classes.Lection;
import task3.classes.LecturesGenerator;
import task3.classes.Reporter;
import task3.classes.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Analytics {

    public static void main(String[] args) {

        System.out.print(LocalDate.now());
        String[] names = {"Артем","Андрей","Владимир","Виктор","Гришка","Дмитрий","Евгений","Юрий","Николай","Александр"};

        List<Student> students = new ArrayList<Student>();
        for (int i = 0 ; i < 10; i++){
            students.add( new Student(names[i] , LecturesGenerator.getLecturesList(5) ) );
        }

        Reporter.evenOnlyOneVisitLecture("Физика",students);
        System.out.print(LocalDate.now());
    }
}
