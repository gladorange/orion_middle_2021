package com.orion.lesson9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class XmlSerializer {



    @Retention(RetentionPolicy.RUNTIME)
    public static @interface XmlField {
        String xmlName();
    }


    @Retention(RetentionPolicy.RUNTIME)
    public static @interface XmlIgnore {
    }


    public static class Person {

        @XmlField(xmlName = "Name")
        String name;

        @XmlField(xmlName = "Surname")
        String lastName;

        @XmlIgnore
        String password;

        public Person(String name, String lastName, String password) {
            this.name = name;
            this.lastName = lastName;
            this.password = password;
        }
    }

    public static void main(String[] args) throws IllegalAccessException {

        Person vasya = new Person("Vasya","Pupkin","123AQW");
        System.out.println(toXml(vasya));

    }


    public static String toXml(Object object) throws IllegalAccessException {

        StringBuilder sb = new StringBuilder();
        final Class<?> aClass = object.getClass();

        sb.append("<" + aClass.getSimpleName() + ">\n");

        for (Field declaredField : aClass.getDeclaredFields()) {

            if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }

            String name = declaredField.getName();
            final XmlField annotation = declaredField.getAnnotation(XmlField.class);

            if (annotation != null) {
                name = annotation.xmlName();
            }

            sb.append("\t<" + name + ">");
            declaredField.setAccessible(true);
            sb.append(declaredField.get(object).toString());
            sb.append("</" + name + ">\n");
        }


        sb.append("</" + aClass.getSimpleName() + ">\n");
        return sb.toString();
    }
}
