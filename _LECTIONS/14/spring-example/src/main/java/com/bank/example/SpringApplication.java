package com.bank.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;

public class SpringApplication {


    public static void main(String[] args) {
        ApplicationContext bankContext = new AnnotationConfigApplicationContext(BankApplicationConfiguration.class);
        final Bank bean = bankContext.getBean(Bank.class);
        System.out.println("start");
        bean.asyncExecution();
        System.out.println("end");
    }


    @Configuration
    @EnableAsync
    public static class BankApplicationConfiguration {

        @Bean
        public PersonnelDepartment personnelDepartment() {
            return new PersonnelDepartment();
        }

        @Bean
        public HrDepartment heDepartment(PersonnelDepartment personnelDepartment) {
            return new HrDepartment(personnelDepartment);
        }

        @Bean
        public Bank bank() {
            System.out.println("Вызываю банк");
            return new Bank(personnelDepartment());
        }


    }
}
