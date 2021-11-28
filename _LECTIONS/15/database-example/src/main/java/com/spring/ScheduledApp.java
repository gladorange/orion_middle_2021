package com.spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.BeanInAnotherPackage;
import com.LoggingPostProcessor;
import com.LoggingPostProcessor.Loggable;

public class ScheduledApp {

    public static void main(String[] args) {
         Class<?> scheduledConfigClass = ScheduledConfig.class;

        if (true) {
            scheduledConfigClass = DisabledScheduledConfig.class;
        }

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(scheduledConfigClass);


        final Loggable bean = applicationContext.getBean(Loggable.class);
        System.out.println(bean.logMessage());
    }

    @ComponentScan
    @EnableScheduling
    public static class ScheduledConfig {

    }


    @ComponentScan
    @Import(BeanInAnotherPackage.class)
    @EnableLogging
    public static class DisabledScheduledConfig {

    }


    @Retention(RetentionPolicy.RUNTIME)
    @Import(LoggingPostProcessor.class)
    public @interface EnableLogging {

    }
}
