package com.orion.lection16.zoos.repository;

import com.orion.lection16.zoos.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
