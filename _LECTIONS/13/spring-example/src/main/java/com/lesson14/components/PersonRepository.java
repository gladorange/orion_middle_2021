package com.lesson14.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.orion.Person;


@Repository
public class PersonRepository {

    public PersonRepository() {
        System.out.println("PersonRepository constructor");
    }

    List<Person> findAllPersons() {
        final ArrayList<Person> objects = new ArrayList<>();
        objects.add(new Person("Vasya", "Pupkin"));
        objects.add(new Person("Petya", "Ivanov"));
        return objects;
    }
}
