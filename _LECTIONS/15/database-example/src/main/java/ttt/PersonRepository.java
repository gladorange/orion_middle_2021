package ttt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
public class PersonRepository {


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Person {
        String name;
        String lastName;
        List<Vacation> vacations = new ArrayList<>();
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Vacation {
        LocalDate start;
        LocalDate end;
    }



    public List<Person> findAllPerson() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Vasya", "Pupkin", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));
        result.add(new Person("Petya", "Ivanov", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));
        result.add(new Person("Masha", "Petrova", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));

        return result;
    }


}
