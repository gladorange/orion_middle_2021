package com.orion.lesson16.springboot.example.service;


import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orion.lesson16.springboot.example.entity.Food;
import com.orion.lesson16.springboot.example.entity.Person;
import com.orion.lesson16.springboot.example.repository.FoodRepository;
import com.orion.lesson16.springboot.example.repository.PersonRepository;

@Service
public class PersonService {


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PersonRepository repository;

    @Autowired
    FoodRepository foodRepository;

    @Transactional
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public Person getPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }


    @Transactional
    public void createPetyaWithFavoriteFood() {

      /*  Food bread = new Food(null, "Хлеб");
        bread = foodRepository.save(bread);

        Person vasya = new Person(null, "Petya", Arrays.asList(bread));
        repository.save(vasya);*/
    }

    @Transactional
    public Person getPetya() {
        final Person petya = repository.findByName("Petya");
        // Hibernate.initialize(petya.getFavoriteFood());
        return petya;
    }

}
