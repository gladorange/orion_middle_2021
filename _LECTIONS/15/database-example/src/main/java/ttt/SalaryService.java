package ttt;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SalaryService {


    final PersonRepository personRepository;

    public SalaryService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    void printSalary() {
        personRepository.findAllPerson()
                .forEach(p -> System.out.println(String.format("%s - %s", p.getLastName()+", " +p.getName(), new Random().nextInt(100))));
    }
}
