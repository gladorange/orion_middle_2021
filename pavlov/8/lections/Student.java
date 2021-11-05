package lections;

import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

public class Student {
    private final String name;
    private final Set<Lection> lections;

    public Student(String name, Supplier<Set<Lection>> lectionsGenerator){
        this(name, lectionsGenerator.get());
    }

    public Student(String name, Set<Lection> lections){
        this.name = name;
        this.lections = lections;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public void printInfo(){
        System.out.println(getName());
        for(Lection lection: lections){
            System.out.println(lection.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(lections, student.lections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lections);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lections=" + lections +
                '}';
    }
}
