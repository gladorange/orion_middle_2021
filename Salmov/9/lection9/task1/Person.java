package lection9.task1;

@Task1.XmlTypeName(xmlTypeName = "Человек")
class Person {

    @Task1.XmlName(xmlName = "Имя")
    String name;

    @Task1.XmlName(xmlName = "Возраст")
    Double age;

    @Task1.XmlIgnore
    String password;

    public Person(String name, Double age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public Person() {
        this("", 30.0, "");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                "}\n";
    }
}
