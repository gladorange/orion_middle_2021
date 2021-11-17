package task1;

@XMLSerializer.XmlTypeName(className = "Персонаж")
class Person{
    @XMLSerializer.XmlName(fieldName = "ИмяЕго")
    public String name ;
    @XMLSerializer.XmlName(fieldName = "ВозрастЕго")
    private Integer age;

    private Boolean alive;


    Person( ){

        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                '}';
    }
}
