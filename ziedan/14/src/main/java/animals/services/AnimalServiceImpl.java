package animals.services;

import animals.models.Cat;
import animals.models.Dog;
import animals.repositories.CatRepository;
import animals.repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private CatRepository catRepository;
    private DogRepository dogRepository;

    @Override
    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<Dog> findDogByName(String name) {
        return dogRepository.findByName(name);
    }

    @Override
    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Optional<Cat> findCatByName(String name) {
        return catRepository.findByName(name);
    }

    @Override
    public Optional<Dog> findLoudestDog() {
        return dogRepository.findAll()
                .stream().max(Comparator.comparing(Dog::getVolume));
    }

    @Override
    public Optional<Cat> findQuietestCat() {
        return catRepository.findAll()
                .stream().min(Comparator.comparing(Cat::getVolume));
    }
}
