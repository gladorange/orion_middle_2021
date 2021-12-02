package ru.task14;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static ru.task14.Cat.CAT_MEOW_MAX_LOUDNESS;

@Repository
public class CatRepository {
    private final List<Cat> repo = Collections.synchronizedList(new ArrayList<>());

    public CatRepository() {
        repo.add(new Cat("Murrrka", ThreadLocalRandom.current().nextLong(0, CAT_MEOW_MAX_LOUDNESS)));
        repo.add(new Cat("Puffy", ThreadLocalRandom.current().nextLong(0, CAT_MEOW_MAX_LOUDNESS)));
        repo.add(new Cat("Mashka", ThreadLocalRandom.current().nextLong(0, CAT_MEOW_MAX_LOUDNESS)));
        repo.add(new Cat("Kitty", ThreadLocalRandom.current().nextLong(0, CAT_MEOW_MAX_LOUDNESS)));
    }

    public void addCat(Cat cat) {
        repo.add(cat);
    }

    public List<Cat> getAllCats() {
        return repo;
    }

    public List<Cat> getCatsByName(String name) {
        return repo.stream().filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
    }
}
