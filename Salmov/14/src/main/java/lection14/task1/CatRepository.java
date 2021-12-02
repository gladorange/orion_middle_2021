package lection14.task1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CatRepository {
    final private List<Cat> cats;

    public CatRepository() {
        cats = new ArrayList<>();
        Random r = new Random();
        cats.add( new Cat("Барсик", r.nextInt(100)));
        cats.add( new Cat("Мурзик", r.nextInt(100)));
        cats.add( new Cat("Матроскин", r.nextInt(100)));
        System.out.println("Коты созданы: " + cats);
    }

    public List<Cat> findAllCats(){
        return cats;
    }

    public Cat findCatByName(String name){
        Cat cat = null;
        for (Cat c: cats) {
            if(name.equals(c.getName()))
                cat = c;
        }
        return cat;
    }
}
