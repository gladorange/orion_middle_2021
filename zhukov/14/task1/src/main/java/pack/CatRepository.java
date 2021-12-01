package pack;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatRepository {

    CatRepository(){
        System.out.println("pack.Cat repository created");
    }
    public List<Cat> findAllInstances(){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat("Barsik",32));
        list.add(new Cat("Sharik",10));
        list.add(new Cat("Kruzhok",62));
        list.add(new Cat("Gav",14));

        return list;
    }
}
