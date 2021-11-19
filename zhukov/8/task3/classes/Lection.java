package task3.classes;

import java.time.LocalDate;
import java.util.Date;

public class Lection {
    private String title ;
    private LocalDate date ;

    public Lection(String title, LocalDate date){
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
