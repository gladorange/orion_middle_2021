package task3.classes;

import java.util.Set;

public class Student {

   private String name ;
   private Set<Lection> visitedLectures ;

    public Student(String name,Set<Lection> lectures){
        this.name = name;
        this.visitedLectures = lectures;
    }

    public Set<Lection> getVisitedLectures() {
        return visitedLectures;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", visitedLectures=" + visitedLectures +
                '}';
    }
}
