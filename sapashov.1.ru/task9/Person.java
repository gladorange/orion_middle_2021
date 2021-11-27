package task9;

@XmlTypeName(key = "Person")
public class Person {

    @XmlName(name = "name")
    String firstName;

    @XmlName(name = "age")
    double age;

    @XmlIgnore
    String password;


    public Person(String firstName, Double age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
