package com.orion.lesson16.springboot.example.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.orion.lesson16.springboot.example.entity.Person;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    final PersonService personService;



    @PostConstruct
    public void postConstruct() {
       /* final Person vasya = new Person(null, "Vasya", null);
        personService.savePerson(vasya);
        final Person anotherVasya = personService.getPersonById(vasya.getId());
        System.out.println(vasya == anotherVasya);*/


        personService.createPetyaWithFavoriteFood();
        final Person petya = personService.getPetya();
        System.out.println(petya.getFavoriteFood());
    }



}
