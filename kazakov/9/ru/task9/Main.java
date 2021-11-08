
package ru.task9;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    @JsOnSerializer.JsonTypeName("Человек")
    public static class Person {

        @JsOnSerializer.JsonName("Name")
        String name;

        @JsOnSerializer.JsonName("Surname")
        String lastName;

        @JsOnSerializer.JsonName("Возраст")
        double age = 13.75;

        @JsOnSerializer.JsonName("Online")
        boolean online = true;

        @JsOnSerializer.JsonIgnore
        String password;

        public Person(String name, String lastName, String password, boolean online, double age) {
            this.name = name;
            this.lastName = lastName;
            this.password = password;
            this.online = online;
            this.age = age;
        }

        public Person() {
        }
    }

    @JsOnSerializer.JsonTypeName("Донатор")
    static class Student {

        @JsOnSerializer.JsonName("Name")
        String name;

        @JsOnSerializer.JsonName("Возраст")
        double age;

        @JsOnSerializer.JsonName("Donator")
        boolean donator;

        @JsOnSerializer.JsonName("DonationsNum")
        int donations;

        @JsOnSerializer.JsonName("Carer")
        boolean carer;

        @JsOnSerializer.JsonName("Guardian")
        boolean guardian;

        boolean paired;

        public Student(String name, double age, boolean donator, int donations, boolean carer, boolean guardian, boolean paired) {
            this.name = name;
            this.age = age;
            this.donator = donator;
            this.donations = donations;
            this.carer = carer;
            this.guardian = guardian;
            this.paired = paired;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", donator=" + donator +
                    ", donations=" + donations +
                    ", carer=" + carer +
                    ", guardian=" + guardian +
                    ", paired=" + paired +
                    '}';
        }

        public Student() {
        }
    }

    public static void main(String[] args) {

        try (JsOnSerializer jsonSerial = new JsOnSerializer()) {

            final Collection<Object> heilsham = new ArrayList<>();
            Person vasya = new Person("Vasya", "Pupkin", "123AQW", false, 35);
            Student kath = new Student("Kathy", 31.7, false, 2, true, false, true);
            Student ruth = new Student("Ruth", 32, true, 4, false, false, false);
            Student chris = new Student("Chrissie", 30, true, 3, false, false, false);
            heilsham.add(vasya);
            heilsham.add(kath);
            heilsham.add(ruth);
            heilsham.add(chris);
            /*
              Создайте метод String serialize(Collection<?> object), который может записывать любые
              объекты в формате XML (или JSON, или YAML, если вам так больше нравится):
             */
            String json = jsonSerial.toJsOn(heilsham);
            System.out.println(json);

            final Collection<Object> collectKathy = new ArrayList<>();
            collectKathy.add(kath);
            json = jsonSerial.toJsOn(collectKathy);
            System.out.println(json);
            /*
            Создайте класс, который может читать любой объект в формате XML.
            например ,deserialize(<пример выше>, Person.class) вернет экземпляр Person{name="Vasya",age=12,password=null}
             */
            Student clonedKath = (Student) jsonSerial.fromJsOn(json, Student.class);
            assert (clonedKath != null);
            System.out.println(clonedKath);

        } catch (Exception e) {
            System.out.printf("Произошло исключение при выполнении метода, сообщение: %s\n", e.getMessage());
            e.printStackTrace();
        }
    }
}
