package animals.repositories;

import animals.models.Dog;

import java.util.List;
import java.util.Optional;

public interface DogRepository {
    List<Dog> findAll();
    Optional<Dog> findByName(String name);
}
