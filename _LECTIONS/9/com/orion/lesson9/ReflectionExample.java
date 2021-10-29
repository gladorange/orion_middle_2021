package com.orion.lesson9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        final Person person = new Person(null, null, 18);

        final Class<?> personClass = Class.forName("com.orion.lesson9.Person");

       /* final Person person = personClass.newInstance();
        System.out.println(person);*/

        final Constructor<Person>[] declaredConstructors = (Constructor<Person>[]) personClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        declaredConstructors[0].setAccessible(true);
        final Person vasya = declaredConstructors[0].newInstance("Vasya", "Pupkin", 18);

        System.out.println(vasya.getLastName());


        final Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        for (Field declaredField : declaredFields) {
            if (declaredField.getType() == String.class) {
                declaredField.setAccessible(true);
                declaredField.set(vasya,"some string");
            }
        }


        System.out.println(vasya);

        final Method[] declaredMethods = personClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));


        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getParameterTypes().length > 0 && declaredMethod.getParameterTypes()[0] == String.class) {
                declaredMethod.invoke(vasya, "Vasya");
            }
        }

        System.out.println(vasya);



    }


}
