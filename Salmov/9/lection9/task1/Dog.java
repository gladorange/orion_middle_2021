package lection9.task1;

@Task1.XmlTypeName(xmlTypeName = "Собака")
class Dog {

    @Task1.XmlName(xmlName = "Кличка")
    String name;

    @Task1.XmlName(xmlName = "Порода")
    String breed;

    @Task1.XmlName(xmlName = "ЛюбимаяЕда")
    String lovelyFood;

    public Dog(String name, String breed, String lovelyFood) {
        this.name = name;
        this.breed = breed;
        this.lovelyFood = lovelyFood;
    }

    public Dog() {
        this("", "", "");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", lovelyFood='" + lovelyFood + '\'' +
                "}\n";
    }
}
