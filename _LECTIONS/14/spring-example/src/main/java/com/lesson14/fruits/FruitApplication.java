package com.lesson14.fruits;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.SneakyThrows;

@Configuration
@ComponentScan
@EnableScheduling
@EnableCaching
@EnableAsync
public class FruitApplication {


    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FruitApplication.class);


        final FruitShop bean = context.getBean(FruitShop.class);
       // bean.printFruits();
     /*   System.out.println(bean.getSomeRandomInteger());
        System.out.println(bean.getSomeRandomInteger());
        System.out.println(bean.getSomeRandomInteger());*/

    /*    System.out.println("Начало ");
        bean.printSomeRandomInteger();
        bean.printSomeRandomInteger();
        bean.printSomeRandomInteger();
        bean.printSomeRandomInteger();
        System.out.println("Конец");*/

    }

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("integer-cache")));
        return cacheManager;
    }


    @Bean
    public BeanPostProcessor fruitPostProcessor() {
        return new FruitPostProcessor();
    }

    public static class FruitPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

            final Class<?>[] interfaces = bean.getClass().getInterfaces();

            if (interfaces.length == 1 &&  interfaces[0] == FruitFactory.class) {

                final Object o = Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, new InvocationHandler() {
                    @SneakyThrows
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        System.out.println("Вызывается метод " + method.getName() + " с аргументами " + Arrays.toString(args));
                        return method.invoke(bean);
                    }

                });

                return o;
            }

            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }
    }
}
