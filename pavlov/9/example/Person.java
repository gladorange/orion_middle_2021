package example;

import selialization.annotations.XmlIgnore;
import selialization.annotations.XmlName;
import selialization.annotations.XmlTypeName;

@XmlTypeName("Человек")
public class Person {
    @XmlName("Имя")
    String firstName;

    @XmlName("Возраст")
    double age;

    @XmlIgnore
    String password;

    public Person(String firstName, double age, String password) {
        this();
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    private Person(){}

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
