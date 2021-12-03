package com.orion.lection16.zoos.service;

import com.orion.lection16.zoos.entity.Zoo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    final ZoosService zoosService;

    @PostConstruct
    public void postConstruct(){
        zoosService.createPositions();
        zoosService.createZoos();
        List<Zoo> zoos = zoosService.findAllZoos();
        for (Zoo zoo: zoos) {
            System.out.println("/////////////////////////////////////////");
            System.out.println(zoo);
            System.out.println("В этом зоопарке такие животные:");
            System.out.println(zoo.getAnimals());
            System.out.println("В этом зоопарке работают сотрудники:");
            System.out.println(zoo.getZooKeepers());
            System.out.println("/////////////////////////////////////////\n");
        }
    }
}
