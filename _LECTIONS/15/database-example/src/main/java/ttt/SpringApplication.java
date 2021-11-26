package ttt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class SpringApplication {


    @org.springframework.context.annotation.Configuration
    public static class Configuration {

        @Bean
        PersonRepository personRepository() {
            return new PersonRepository();
        }

        @Bean
        PersonService personService(PersonRepository personRepository ) {
            return new PersonService(personRepository);
        }

        @Bean
        SalaryService salaryService(PersonRepository personRepository ) {
            return new SalaryService(personRepository);
        }


    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        final PersonService bean = context.getBean(PersonService.class);
        System.out.println(bean.getSumOfVacationsForEveryPerson());

    }
}
