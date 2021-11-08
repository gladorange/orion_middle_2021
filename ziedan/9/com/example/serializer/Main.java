package com.example.serializer;

import java.util.Arrays;

public class Main {



    @XmlSerializer.XmlTypeName(name = "Человек")
    static class Person {
        @XmlSerializer.XmlName(name = "Имя")
        String name;

        @XmlSerializer.XmlName(name="Возраст")
        int age;

        boolean isMarried;

        @XmlSerializer.XmlIgnore
        String password;

        public Person(String name, int age, boolean isMarried) {
            this.name = name;
            this.age = age;
            this.isMarried = isMarried;
        }

        public Person() {

        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", isMarried=" + isMarried +
                    '}';
        }
    }

    static class Flight {
        @XmlSerializer.XmlName(name = "ID")
        int id;

        @XmlSerializer.XmlName(name = "code")
        String flightCode;

        @XmlSerializer.XmlName(name = "departure-airport")
        String originAirport;

        @XmlSerializer.XmlName(name = "arrival-airport")
        String destinationAirport;

        public Flight(int id, String flightCode, String originAirport, String destinationAirport) {
            this.id = id;
            this.flightCode = flightCode;
            this.originAirport = originAirport;
            this.destinationAirport = destinationAirport;
        }

        public Flight() {
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "id=" + id +
                    ", flightCode='" + flightCode + '\'' +
                    ", originAirport='" + originAirport + '\'' +
                    ", destinationAirport='" + destinationAirport + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String result = XmlSerializer.serialize(Arrays.asList(new Person("Shadi", 32, true)));

        System.out.println(result);

        Person person = (Person) XmlSerializer.deserialize(result, Person.class);
        System.out.println(person);

        Flight flight = new Flight(123, "TK123", "DME", "KZN");

        String serializedFlight = XmlSerializer.serialize(Arrays.asList(flight));
        System.out.println(serializedFlight);

        Flight deserializedFlight = (Flight) XmlSerializer.deserialize(serializedFlight, Flight.class);

        System.out.println(deserializedFlight);

    }
}
