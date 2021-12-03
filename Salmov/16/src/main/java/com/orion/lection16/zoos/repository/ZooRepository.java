package com.orion.lection16.zoos.repository;

import com.orion.lection16.zoos.entity.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Zoo,Long> {

}
