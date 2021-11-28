package com.spring;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPrinter {

    public ScheduledPrinter() {
        System.out.println("Я создался ");
    }

    @Scheduled(fixedRate = 1_000)
    public void  print() {
        System.out.println(LocalDateTime.now());
    }

}
