package com.example.zoo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ZooKeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zoo_keeper_seq")
    Long id;

    @Column
    String name;

    @Column
    String position;

    @ManyToOne
    Zoo zoo;

}
