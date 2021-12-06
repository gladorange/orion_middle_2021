package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnimalService{

    @Autowired
    final DogRepository dogRepository = new DogRepository();
    final CatRepository catRepository = new CatRepository();

    //public AnimalService() throws IOException, InvocationTargetException, IllegalAccessException {}

    void findLoudestDogs(){
        List<Dog> dogs =  this.dogRepository.findAllInstances()
                .stream().sorted(Comparator.comparingInt(Dog::getBarkingVol))
                .collect(Collectors.toList());

        System.out.println(dogs.get(dogs.size()-1) + " , "+dogs.get(dogs.size()-2) );
    }

    void getDogsByName(String name){
        List<Dog>  sameDogs = dogRepository.findAllInstances()
                .stream()
                .filter(el->el.getName().equals(name))
                .collect(Collectors.toList());

        System.out.println(sameDogs );
    }

    void getCatsByName(String name){
        List<Cat>  sameCats = catRepository.findAllInstances()
                .stream()
                .filter(el->el.getName().equals(name))
                .collect(Collectors.toList());

        System.out.println(sameCats);
    }
    void getAllCats(){
        System.out.println(catRepository);
    }

    void getAllDogs(){
        System.out.println(dogRepository);
    }

    void findQuietlyCats(){
        List<Cat> cats =  this.catRepository.findAllInstances()
                .stream().sorted(Comparator.comparingInt(Cat::getPurringVol))
                .collect(Collectors.toList());
        System.out.println(cats.get(0) + " , "+cats.get(1) );
    }

}
