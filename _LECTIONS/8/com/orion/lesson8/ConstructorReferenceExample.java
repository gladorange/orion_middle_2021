package com.orion.lesson8;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ConstructorReferenceExample {


    public static class ObjectFactory<T> {
        final Supplier<T> producer;


        public ObjectFactory(Supplier<T> producer) {
            this.producer = producer;
        }


        public T createObject() {
            return producer.get();
        }

    }

    public static void main(String[] args) {
        ObjectFactory<ArrayList> listObjectFactory = new ObjectFactory<>(ArrayList::new);
      //  ObjectFactory<int[]> listObjectFactory2 = new ObjectFactory<>(tSupplier);

        final ArrayList object = listObjectFactory.createObject();
        object.add("1");
        final ArrayList object2 = listObjectFactory.createObject();
        object2.add("2");


        System.out.println(object);
        System.out.println(object2);



    }






}
