package animals.services;

import animals.models.Cat;
import animals.models.Dog;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Dog> findAllDogs();

    Optional<Dog> findDogByName(String name);

    List<Cat> findAllCats();

    Optional<Cat> findCatByName(String name);

    Optional<Dog> findLoudestDog();

    Optional<Cat> findQuietestCat();
}
