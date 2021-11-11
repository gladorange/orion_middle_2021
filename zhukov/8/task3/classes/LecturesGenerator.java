package task3.classes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public   class LecturesGenerator {

    final static int month = LocalDate.now().getMonthValue();
    final static int year = LocalDate.now().getYear();
    final static int days = LocalDate.MAX.getDayOfMonth();
    final static String[] subjects = {"Физика","Матанализ","Английский язык","Матанализ","История", "Физкультура"};

    public static Set<Lection> getLecturesList(int count){
        Set<Lection> lectures = new HashSet<Lection>();
        for (int i = 0; i<count; i++) {
            int subject = ThreadLocalRandom.current().nextInt(0, subjects.length);
            int day = ThreadLocalRandom.current().nextInt(1, days);
            lectures.add(new Lection(subjects[subject], LocalDate.of(year, month, day)));
        }
        return lectures;
    }
}
