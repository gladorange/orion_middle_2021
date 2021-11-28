package com.orion.lesson16.springboot.example.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orion.lesson16.springboot.example.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


    @Query("SELECT p FROM Person p where p.name=:name")
    @EntityGraph(attributePaths = "favoriteFood")
    Person findByName(String name);
}
