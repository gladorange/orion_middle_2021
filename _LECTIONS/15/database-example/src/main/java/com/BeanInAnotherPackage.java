package com;

import org.springframework.stereotype.Component;

import com.LoggingPostProcessor.Loggable;

@Component
public class BeanInAnotherPackage implements Loggable {


    public BeanInAnotherPackage() {
        System.out.println("В другом package");
    }

    @Override
    public String logMessage() {
        return "я бин в нижнем регистре";
    }
}
