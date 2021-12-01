package pack;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {

    public DogRepository(){
        System.out.println("pack.Dog repository created");
    }

    public List<Dog> findAllInstances(){
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Gav",4));
        dogList.add(new Dog("Belka",70));
        dogList.add(new Dog("Strelka",73));
        dogList.add(new Dog("Charly",12));

        return dogList;
    }


}
