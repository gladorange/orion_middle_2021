package lection14.task1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class DogRepository {

    final private List<Dog> dogs;

    public DogRepository() {
        dogs = new ArrayList<>();
        Random r = new Random();
        dogs.add(new Dog("Барбос", r.nextInt(100)));
        dogs.add(new Dog("Бобик", r.nextInt(100)));
        dogs.add(new Dog("Шарик", r.nextInt(100)));
        System.out.println("Собаки созданы: " + dogs);
    }

    public List<Dog> findAllDogs(){
        return dogs;
    }

    public Dog findDogByName(String name){
        Dog dog = null;
        for (Dog d: dogs) {
            if(name.equals(d.getName()))
                dog = d;
        }
        return dog;
    }
}
