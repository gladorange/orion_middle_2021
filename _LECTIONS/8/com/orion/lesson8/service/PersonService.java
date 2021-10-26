package com.orion.lesson8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class PersonService {
    static class Person {
        String name;
        String lastName;

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }


    private List<Person> persons = new ArrayList<>();

    public PersonService() {
        persons.add(new Person("Vasya", "Pupkin"));
        persons.add(new Person("Vadim", "Ivanov"));
        persons.add(new Person("Alexey", "Petrov"));
        persons.add(new Person("Ilya", "Chesnokov"));
    }

    public List<Person> searchByName(String prefix) {
        return persons.stream()
                .filter(person -> person.name.toLowerCase().startsWith(prefix.toLowerCase()))
                .toList();
    }

    public List<Person> searchByLastName(String prefix) {
        return persons.stream()
                .filter(person -> person.lastName.toLowerCase().startsWith(prefix.toLowerCase()))
                .toList();
    }

    public List<Person> searchByFullName(String searchString) {
        return persons.stream()
                .filter(person -> (person.name.toLowerCase() + " " + person.lastName.toLowerCase()).contains(searchString.toLowerCase()))
                .toList();
    }


    public static void main(String[] args) {
        final PersonService personService = new PersonService();
/*

        System.out.println(personService.searchByLastName("P"));
        System.out.println(personService.searchByName("V"));
        System.out.println(personService.searchByFullName("ey p"));
*/


        System.out.println(personService.searchAnywhere("I"));

    }


    public enum SearchVariants {
        NAME(PersonService::searchByName),
        LAST(PersonService::searchByLastName),
        FULLNAME(PersonService::searchByFullName);
        //FULLNAME((searchService, searchString) -> searchService.searchByFullName(searchString));

        final BiFunction<PersonService, String, List<Person>> searcher;


        SearchVariants(BiFunction<PersonService, String, List<Person>> searcher) {
            this.searcher = searcher;
        }
    }


    public List<Person> searchAnywhere(String searchString) {
        List<Person> result = new ArrayList<>();
/*

        result.addAll(searchByName(searchString));
        result.addAll(searchByLastName(searchString));
        result.addAll(searchByFullName(searchString));
*/

        for (SearchVariants value : SearchVariants.values()) {
            result.addAll(value.searcher.apply(this, searchString));
        }


        return result;
    }



}
