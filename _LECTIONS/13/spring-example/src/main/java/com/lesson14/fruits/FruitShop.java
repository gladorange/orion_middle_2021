package com.lesson14.fruits;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class FruitShop implements ApplicationContextAware {

    @Autowired
    List<FruitFactory> fabrics;

    public FruitShop(List<FruitFactory> fabrics) {
        this.fabrics = fabrics;
        printFruits();
    }

  //  @Scheduled(fixedDelay = 2_000)
    public void printFruits() {
        for (FruitFactory fabric : fabrics) {
            System.out.println(fabric.makeFruit());
        }
    }

    @Autowired
    public void setFabrics(List<FruitFactory> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Fruit shop создался, пишем бины из AC");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

    @SneakyThrows
    @Cacheable("integer-cache")
    public Integer getSomeRandomInteger() {
        Thread.sleep(1000);
        return new Random().nextInt(100);

    }

    @SneakyThrows
    @Async
    public Future printSomeRandomInteger() {
        Thread.sleep(1000);
        final int i = new Random().nextInt(100);
        System.out.println(i);
        return null;

    }

}
