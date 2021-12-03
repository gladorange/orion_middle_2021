package com.orion.lection16.zoos.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    String name;

    @OneToMany(mappedBy="position")
    private Set<ZooKeeper> zooKeepers;

    @Override
    public String toString() {
        return name;
    }
}
