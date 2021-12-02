package ru.task14;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Service
public class AnimalService {
    @Autowired
    CatRepository catRepo;
    @Autowired
    DogRepository dogRepo;

    // - Найти самых громких собак
    public Collection<Dog> getLoudestDogs() {

        Long loudestBark = dogRepo.getAllDogs().stream()
                .map(Dog::getBarkLoud)
                .max(Comparator.comparing(d -> d))
                .orElse(null);

        return dogRepo.getAllDogs().stream()
                .filter(d -> d.getBarkLoud().equals(loudestBark))
                .collect(Collectors.toList());
    }

    //  - Найти самых тихих кошек
    public Collection<Cat> getQuietestCats() {
        Long quietestMeow = catRepo.getAllCats().stream()
                .map(Cat::getMeowLoud)
                .min(Comparator.comparing(d -> d))
                .orElse(null);

        return catRepo.getAllCats().stream()
                .filter(d -> d.getMeowLoud().equals(quietestMeow))
                .collect(Collectors.toList());
    }

    public void addCat(String name, Long loud) {
        catRepo.addCat(new Cat(name, loud));
    }

    public void addDog(String name, Long loud) {
        dogRepo.addDog(new Dog(name, loud));
    }

    //  - найти всех кошек
    public Collection<Cat> getAllCats() {
        return catRepo.getAllCats();
    }

    //  - найти всех собак
    public Collection<Dog> getAllDogs() {
        return dogRepo.getAllDogs();
    }

    //  - найти собаку по имени
    public Collection<Dog> getDogsByName(String name) {
        return dogRepo.getDogsByName(name);
    }

    //  - найти кошку по имени
    public Collection<Cat> getCatsByName(String name) {
        return catRepo.getCatsByName(name);
    }

    void processUserCommand(String command) {
        String[] args = command.split(" ");
        switch (args[0]) {
            case "getAllCats" -> getAllCats().forEach(System.out::println);
            case "getAllDogs" -> getAllDogs().forEach(System.out::println);
            case "getQuietestCats" -> getQuietestCats().forEach(System.out::println);
            case "getLoudestDogs" -> getLoudestDogs().forEach(System.out::println);
            case "getCatsByName" -> getCatsByName(args[1]).forEach(System.out::println);
            case "getDogsByName" -> getDogsByName(args[1]).forEach(System.out::println);
            default -> {
            }
        }
    }
}
