package lection14.task1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    final private DogRepository dogRepository;
    final private CatRepository catRepository;

    @AnimalMethod(
            name = "loudDogs",
            description = "найти самых громких собак"
    )
    public List<Dog> findMostLoudDogs(){
        List<Dog> dogs = dogRepository.findAllDogs();
        Integer maxVolume = Collections.max(dogs, Comparator.comparing(Animal::getVolume)).getVolume();
        return dogs.stream()
                .filter(d->d.getVolume().equals(maxVolume))
                .collect(Collectors.toList());
    }

    @AnimalMethod(
            name = "quietCats",
            description = "найти самых тихих котов"
    )
    public List<Cat> findMostQuietCats(){
        List<Cat> cats = catRepository.findAllCats();
        Integer minVolume = Collections.min(cats, Comparator.comparing(Animal::getVolume)).getVolume();
        return cats.stream()
                .filter(c->c.getVolume().equals(minVolume))
                .collect(Collectors.toList());
    }

    @AnimalMethod(
            name = "dogByName",
            description = "найти собаку по имени (формат: dogByName Кличка)",
            argsQuantity = 1
    )
    public Dog findDogByName(String name){
        return dogRepository.findDogByName(name);
    }

    @AnimalMethod(
            name = "catByName",
            description = "найти кота по имени (формат: catByName Кличка)",
            argsQuantity = 1
    )
    public Cat findCatByName(String name){
        return catRepository.findCatByName(name);
    }

    @AnimalMethod(
            name = "allDogs",
            description = "найти всех собак"
    )
    public List<Dog> findAllDogs(){
        return dogRepository.findAllDogs();
    }

    @AnimalMethod(
            name = "allCats",
            description = "найти всех котов"
    )
    public List<Cat> findAllCats(){
        return catRepository.findAllCats();
    }
}
