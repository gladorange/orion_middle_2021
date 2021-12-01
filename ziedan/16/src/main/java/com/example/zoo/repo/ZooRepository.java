package com.example.zoo.repo;

import com.example.zoo.entities.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, Long> {
}
