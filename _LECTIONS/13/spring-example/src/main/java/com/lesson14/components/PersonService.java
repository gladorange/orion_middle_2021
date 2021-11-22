package com.lesson14.components;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.orion.Person;

@Service
public class PersonService {

    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        System.out.println(findPersonsByFirstLetter('V'));

    }


    List<Person> findPersonsByFirstLetter(Character character) {
        return personRepository.findAllPersons()
                .stream()
                .filter(p -> p.getName().toCharArray()[0] == character)
                .collect(Collectors.toList());
    }
}
