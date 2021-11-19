package task3;

import task3.classes.LecturesGenerator;
import task3.classes.Reporter;
import task3.classes.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Analytics {

    public static void main(String[] args) {


        String[] names = {"Артем","Андрей","Владимир","Виктор","Гришка","Дмитрий","Евгений","Юрий","Николай","Александр"};

        List<Student> students = new ArrayList<Student>();
        for (int i = 0 ; i < 10; i++){
            students.add( new Student(names[i] , LecturesGenerator.getLecturesList(5) ) );
        }
        System.out.print(LocalDate.now());
       // Reporter.evenOnlyOneLectureVisit("Физика",students);
       // Reporter.studentsVisitStat(students);
       // Reporter.maxVisitedLectures(students);
        //Reporter.maxVisitedStudents(LocalDate.now() ,students );
        Reporter.courseStatistic(students);
    }
}
