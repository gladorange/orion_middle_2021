package classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AppsReport {


    public static void   sortByScoreCount(List<Triple<String,Double,Double>> apps){
        Collections.sort( apps ,(a,b)-> (int) (a.getSecond() - b.getSecond()));

        for (Triple a:apps) {
            System.out.printf("Приложение - %s. Количество голосов - %s. Рейтинг %s \n",a.getFirst(),a.getSecond(),a.getThird() );
        }
    }

    public static void bestRatingApp(List<Triple<String,Double,Double>> apps){
        Triple<String,Double,Double> app = Collections.max(apps,Comparator
                .comparingDouble((Triple<String,Double,Double> compareApp)-> compareApp.getThird() ));

        System.out.printf("Приложение %s имеет лучший рейтинг %s \n",app.getFirst(),app.getThird());
        //Если предполагается, что у приложений может быть одинаковый рейтинг
        //allSameRating(apps , app.getThird());
    }

    private static void allSameRating(List<Triple<String,Double,Double>> apps,Double rating ) {
        apps = apps.stream()
                .filter(curEl -> Objects.equals(curEl.getThird(),rating))
                .collect(Collectors.toList());

        for (Triple app: apps) {
            System.out.printf("Приложение %s имеет рейтинг %s \n",app.getFirst(),app.getThird());
        }
    }
    public static void worseRatingApp(List<Triple<String,Double,Double>> apps){
       Triple<String,Double,Double> app = Collections.min(apps,Comparator
                .comparingDouble((Triple<String,Double,Double> compareApp)-> compareApp.getThird() ));

       System.out.printf("Приложение %s имеет худший рейтинг %s \n",app.getFirst(),app.getThird());
        //Если предполагается, что у приложений может быть одинаковый рейтинг
        //allSameRating(apps , app.getThird());
    }

}
