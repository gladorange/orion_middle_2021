package task8.lections;

import java.time.LocalDate;

public class Lection {
    private String name;
    private LocalDate time;

    public Lection(String name, LocalDate time) {
        this.name = name;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Lection{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
