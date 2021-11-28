package ttt;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import ttt.PersonRepository.Person;


@Component
public class PersonService {


    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public long getSumOfVacationsForEveryPerson() {
        final List<Person> allPerson = personRepository.findAllPerson();
        return allPerson.stream()
                .flatMap(p -> p.vacations.stream())
                .mapToLong(v -> ChronoUnit.DAYS.between(v.start, v.end) + 1)
                .sum();

    }


    public static void main(String[] args) {
        PersonService service = new PersonService(new PersonRepository());
        System.out.println(service.getSumOfVacationsForEveryPerson());

        SalaryService salaryService = new SalaryService(new PersonRepository());
        salaryService.printSalary();

    }
}
