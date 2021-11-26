package com;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;


public class LoggingPostProcessor implements BeanPostProcessor {

    public LoggingPostProcessor() {
        System.out.println("LoggingPostProcessor");
    }

    public interface Loggable {
        String logMessage();
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Class<?>[] interfaces = bean.getClass().getInterfaces();
        if (interfaces.length > 0 && interfaces[0] == Loggable.class) {
            final Loggable o = (Loggable) Proxy.newProxyInstance(BeanPostProcessor.class.getClassLoader(), interfaces, new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    final Object invoke = method.invoke(bean);
                    if (invoke instanceof String) {
                        return ((String) invoke).toUpperCase();
                    }
                    return invoke;
                }
            });
            return o;
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
