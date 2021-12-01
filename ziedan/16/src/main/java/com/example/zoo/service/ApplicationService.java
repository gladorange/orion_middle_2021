package com.example.zoo.service;

import com.example.zoo.dto.AnimalDto;
import com.example.zoo.dto.ZooKeeperDto;
import com.example.zoo.entities.Zoo;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ApplicationService {
    ZooService zooService;

    @PostConstruct
    public void initZoo() {
        Faker faker = new Faker(new Locale("ru"));
        for (int i = 0; i < 3; i++) {
            Zoo zoo = zooService.createZoo(faker.funnyName().name());
            for (int j = 0; j < 50; j++) {
                zooService.createAnimal(new AnimalDto(null, faker.animal().name(), zoo));
                zooService.createZooKeeper(new ZooKeeperDto(null, faker.name().fullName(), faker.job().position(), zoo));
            }
        }

    }


}
