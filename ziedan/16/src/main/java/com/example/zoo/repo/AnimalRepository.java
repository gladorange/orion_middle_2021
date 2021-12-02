package com.example.zoo.repo;

import com.example.zoo.entities.Animal;
import com.example.zoo.entities.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAllByZoo(Zoo zoo);
}
