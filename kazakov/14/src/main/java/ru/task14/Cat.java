package ru.task14;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cat {
    final public static long CAT_MEOW_MAX_LOUDNESS = 60L; // in Decibells

    @Id
    @GeneratedValue
    private Long id;
    private  String name;
    private Long meowLoud;

    public Cat(String name, Long meowLoud) {
        this.name = name;
        this.meowLoud = meowLoud;
    }

    public Long getMeowLoud() {
        return meowLoud;
    }

    public String getName() {
        return name;
    }
}
