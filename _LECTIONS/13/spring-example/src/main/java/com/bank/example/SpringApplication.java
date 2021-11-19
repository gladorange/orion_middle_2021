package com.bank.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class SpringApplication {


    public static void main(String[] args) {
        ApplicationContext bankContext = new AnnotationConfigApplicationContext(BankApplicationConfiguration.class);
    }


    @Configuration
    public static class BankApplicationConfiguration {

        @Bean
        public PersonnelDepartment personnelDepartment() {
            return new PersonnelDepartment();
        }

        @Bean
        public HrDepartment heDepartment() {
            return new HrDepartment(personnelDepartment());
        }

        @Bean
        public Bank bank() {
            System.out.println("Вызываю банк");
            return new Bank(personnelDepartment());
        }


    }
}
