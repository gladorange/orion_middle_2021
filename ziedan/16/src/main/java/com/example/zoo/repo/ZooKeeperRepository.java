package com.example.zoo.repo;

import com.example.zoo.entities.ZooKeeper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooKeeperRepository extends JpaRepository<ZooKeeper, Long> {
}