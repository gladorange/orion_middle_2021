package com.orion.lection16.zoos.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    String name;

    @OneToMany(mappedBy="zoo")
    private Set<Animal> animals;

    @OneToMany(mappedBy="zoo")
    private Set<ZooKeeper> zooKeepers;

    @Override
    public String toString() {
        return "\nZoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
