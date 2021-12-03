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
public class Dog {
    final public static long DOG_BARK_MAX_LOUDNESS = 110L;

    @Id
    @GeneratedValue
    private Long id;
    private  String name;
    private Long barkLoud;

    public Dog(String name, Long barkLoud) {
        this.name = name;
        this.barkLoud = barkLoud;
    }

    public Long getBarkLoud() {
        return barkLoud;
    }

    public String getName() {
        return name;
    }
}
