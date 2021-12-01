package com.example.zoo.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zoo_seq")
    Long Id;

    @Column
    String name;

}
