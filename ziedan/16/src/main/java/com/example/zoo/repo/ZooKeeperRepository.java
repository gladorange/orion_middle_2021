package com.example.zoo.repo;

import com.example.zoo.entities.Zoo;
import com.example.zoo.entities.ZooKeeper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooKeeperRepository extends JpaRepository<ZooKeeper, Long> {

    List<ZooKeeper> findAllByZoo(Zoo zoo);
}