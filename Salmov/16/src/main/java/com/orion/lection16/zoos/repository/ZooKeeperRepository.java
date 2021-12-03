package com.orion.lection16.zoos.repository;

import com.orion.lection16.zoos.entity.ZooKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooKeeperRepository extends JpaRepository<ZooKeeper,Long> {
}
