package ttt;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ttt.PersonRepository.Person;
import ttt.PersonRepository.Vacation;

public class TestPersonService {


    @Test
    public void testVacations() {

        List<Person> result = new ArrayList<>();

        result.add(new Person("Vasya", "Pupkin", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));
        result.add(new Person("Petya", "Ivanov", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));


      /*  final PersonRepository personRepository = new PersonRepository() {
            @Override
            public List<Person> findAllPerson() {
                List<Person> result = new ArrayList<>();

                result.add(new Person("Vasya", "Pupkin", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));
                result.add(new Person("Petya", "Ivanov", Arrays.asList(new Vacation(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10)))));

                return result;            }
        };*/

        final PersonRepository mock = mock(PersonRepository.class);

        when(mock.findAllPerson()).thenReturn(result);

        PersonService service = new PersonService(mock);
        Assert.assertEquals("Count should be 20 ",20, service.getSumOfVacationsForEveryPerson());
    }
}
