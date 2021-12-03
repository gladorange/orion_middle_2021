package com.example.zoo.dto;

import com.example.zoo.entities.Zoo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZooKeeperDto {
    private Long id;
    private String name;
    private String position;
    private Zoo zoo;
}
