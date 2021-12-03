package com.example.zoo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
    Long id;

    @Column
    String name;

    @ManyToOne
    Zoo zoo;

}

