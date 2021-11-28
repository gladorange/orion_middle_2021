package com.orion.lesson16.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orion.lesson16.springboot.example.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
}
