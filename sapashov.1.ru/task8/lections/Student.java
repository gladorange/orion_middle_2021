package task8.lections;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lection> lections;

    public Student(String name, Set<Lection> lections) {
        this.name = name;
        this.lections = lections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public void setLections(Set<Lection> lections) {
        this.lections = lections;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lections=" + lections +
                '}';
    }
}
