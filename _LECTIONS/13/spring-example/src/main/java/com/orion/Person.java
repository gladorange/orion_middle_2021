package com.orion;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@AllArgsConstructor
@ToString
@With
@Builder
public class Person {
    final String name;
    final String lastName;


    public static void main(String[] args) {
        Person vasya = new Person("vasya", "Pupkin");
        System.out.println(vasya);
        System.out.println(vasya.getName());
        System.out.println(vasya.getLastName());

        final Person newVasya = vasya.withName("Vasya");
        System.out.println(newVasya);


        final Person pupkin = Person.builder().lastName("Pupkin").build();
        System.out.println(pupkin);
    }
}
