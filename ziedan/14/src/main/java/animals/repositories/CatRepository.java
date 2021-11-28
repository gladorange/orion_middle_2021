package animals.repositories;

import animals.models.Cat;

import java.util.List;
import java.util.Optional;

public interface CatRepository {
    List<Cat> findAll();
    Optional<Cat> findByName(String name);
}
