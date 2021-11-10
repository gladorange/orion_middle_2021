package lection8.task3;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {
    private final String name;
    private final LocalDate lectionDate;

    public Lection(String name, LocalDate lectionDate) {
        this.name = name;
        this.lectionDate = lectionDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLectionDate() {
        return lectionDate;
    }

    @Override
    public String toString() {
        return "\n{" +
                name +
                " : " + lectionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lection)) return false;
        Lection lection = (Lection) o;
        return getName().equals(lection.getName()) && getLectionDate().equals(lection.getLectionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLectionDate());
    }
}
