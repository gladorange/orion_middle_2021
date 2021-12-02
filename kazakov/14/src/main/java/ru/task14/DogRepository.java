package ru.task14;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static ru.task14.Dog.DOG_BARK_MAX_LOUDNESS;

@Repository
public class DogRepository {

    private final List<Dog> repo = Collections.synchronizedList(new ArrayList<>());

    public void addDog(Dog dog) {
        repo.add(dog);
    }

    public DogRepository() {
        repo.add(new Dog("Bobik", ThreadLocalRandom.current().nextLong(0, DOG_BARK_MAX_LOUDNESS)));
        repo.add(new Dog("Sharik", ThreadLocalRandom.current().nextLong(0, DOG_BARK_MAX_LOUDNESS)));
        repo.add(new Dog("Tuzik", ThreadLocalRandom.current().nextLong(0, DOG_BARK_MAX_LOUDNESS)));
        repo.add(new Dog("Archie", ThreadLocalRandom.current().nextLong(0, DOG_BARK_MAX_LOUDNESS)));
    }

    public List<Dog> getAllDogs() {
        return repo;
    }

    public List<Dog> getDogsByName(String name) {
        return repo.stream().filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
    }
}
