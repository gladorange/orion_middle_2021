package task3;

import classes.AppsReport;
import classes.Triple;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        //task.с

        System.out.print("------\ntask.с\n------\n");

        List<Triple<String,Double,Double>> appsList = new ArrayList<>();
        // не совсем понял как количество оценок может быть double, но да ладно
        appsList.add(new Triple<String,Double,Double>("VK",3100.0 , 4.3) );
        appsList.add(new Triple<String,Double,Double>("Meta(FB)",3270.0 , 3.8));
        appsList.add(new Triple<String,Double,Double>("Yandex Music",329.0 , 4.5));
        appsList.add(new Triple<String,Double,Double>("Spotify",5499.0 , 3.3));
        appsList.add(new Triple<String,Double,Double>("Evernote",6499.0 , 4.97));
        appsList.add(new Triple<String,Double,Double>("GitHub",64499.0 , 4.9));
        appsList.add(new Triple<String,Double,Double>("Zoom",4684.0 , 3.9));
        appsList.add(new Triple<String,Double,Double>("Busuu",3683.0 , 3.5));


        AppsReport.sortByScoreCount(appsList);
        AppsReport.bestRatingApp(appsList);
        AppsReport.worseRatingApp(appsList);
    }
}
