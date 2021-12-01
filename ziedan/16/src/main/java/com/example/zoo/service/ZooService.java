package com.example.zoo.service;

import com.example.zoo.dto.AnimalDto;
import com.example.zoo.dto.ZooKeeperDto;
import com.example.zoo.entities.Animal;
import com.example.zoo.entities.Zoo;
import com.example.zoo.entities.ZooKeeper;
import com.example.zoo.repo.AnimalRepository;
import com.example.zoo.repo.ZooKeeperRepository;
import com.example.zoo.repo.ZooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ZooService {

    private final ZooRepository zooRepository;
    private final AnimalRepository animalRepository;
    private final ZooKeeperRepository zooKeeperRepository;

    @Transactional
    Zoo createZoo(String name) {
        Zoo zoo = new Zoo(null, name);
        return zooRepository.save(zoo);
    }

    @Transactional
    Animal createAnimal(AnimalDto animalDto) {
        Animal animal = new Animal(null, animalDto.getName(), animalDto.getZoo());
        return animalRepository.save(animal);
    }

    @Transactional
    ZooKeeper createZooKeeper(ZooKeeperDto zooKeeperDto) {
        ZooKeeper zooKeeper = new ZooKeeper(null,
                zooKeeperDto.getName(),
                zooKeeperDto.getPosition(),
                zooKeeperDto.getZoo());
        return zooKeeperRepository.save(zooKeeper);
    }

}
