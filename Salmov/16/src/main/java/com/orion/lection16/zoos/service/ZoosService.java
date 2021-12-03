package com.orion.lection16.zoos.service;

import com.orion.lection16.zoos.entity.Animal;
import com.orion.lection16.zoos.entity.Position;
import com.orion.lection16.zoos.entity.Zoo;
import com.orion.lection16.zoos.entity.ZooKeeper;
import com.orion.lection16.zoos.helpers.NamesHelper;
import com.orion.lection16.zoos.repository.AnimalRepository;
import com.orion.lection16.zoos.repository.PositionRepository;
import com.orion.lection16.zoos.repository.ZooKeeperRepository;
import com.orion.lection16.zoos.repository.ZooRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ZoosService {

    @Autowired
    ZooRepository zooRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    ZooKeeperRepository zooKeeperRepository;

    @Transactional
    public void createPositions(){
        List<Position> positions = new ArrayList<>();
        NamesHelper.ZOO_POSITIONS.stream()
                        .forEach(p -> positions.add(new Position(null,p,null)));
        positionRepository.saveAll(positions);
    }

    @Transactional
    public List<Position> findAllPositions(){
        return positionRepository.findAll();
    }

    @Transactional
    public void createZoos(){
        List<Zoo> zoos = new ArrayList<>();
        NamesHelper.ZOO_NAMES.stream()
                .forEach(zn -> zoos.add(new Zoo(null,zn,null,null)));
        zooRepository.saveAll(zoos);
        zoos.stream().forEach(z->createAnimalsInZoo(z,50));
        zoos.stream().forEach(z->createKeepersInZoo(z,50));
    }

    @Transactional
    public List<Zoo> findAllZoos(){
        List<Zoo> zoos = zooRepository.findAll();
        zoos.stream().forEach(z->Hibernate.initialize(z.getAnimals()));
        zoos.stream().forEach(z->Hibernate.initialize(z.getZooKeepers()));
        return zoos;
    }

    @Transactional
    public void createAnimalsInZoo(Zoo zoo, int quantity){
        List<Animal> animals = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < quantity; i++) {
            animals.add(new Animal(null,
                    NamesHelper.ANIMAL_NAMES[r.nextInt(NamesHelper.ANIMAL_NAMES.length)],
                    NamesHelper.ANIMAL_NICKNAMES[r.nextInt(NamesHelper.ANIMAL_NICKNAMES.length)],
                    zoo));
        }
        animalRepository.saveAll(animals);
    }

    @Transactional
    public void createKeepersInZoo(Zoo zoo, int quantity){
        List<ZooKeeper> zooKeepers = new ArrayList<>();
        List<Position> positions = findAllPositions();
        Random r = new Random();
        for (int i = 0; i < quantity; i++) {
            zooKeepers.add(new ZooKeeper(null,
                    NamesHelper.KEEPER_NAMES[r.nextInt(NamesHelper.KEEPER_NAMES.length)],
                    zoo,
                    positions.get(r.nextInt(positions.size()))
                    )
            );
        }
        zooKeeperRepository.saveAll(zooKeepers);
    }

}
