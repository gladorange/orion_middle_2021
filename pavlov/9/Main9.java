import example.Animal;
import example.Car;
import example.Person;
import org.xml.sax.SAXException;
import selialization.XmlDeserializer;
import selialization.XmlSerializer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main9 {
    public static void main(String[] args) throws IllegalAccessException, ParserConfigurationException, XmlDeserializer.XmlDeserializationException, SAXException, IOException {
        Collection<Object> objects = new ArrayList<>();
        objects.add(new Person("Иван", 12, "123"));
        objects.add(new Animal("Тузик", "Собака", true));
        objects.add(new Car("Автоваз", 100));

        XmlSerializer serializer = new XmlSerializer();
        String xml = serializer.serialize(objects);

        System.out.println("Сериализация:");
        System.out.println(xml);

        System.out.println("Десериализация:");
        XmlDeserializer deserializer = new XmlDeserializer();

        System.out.println(deserializer.deserialize(xml, Person.class));
        System.out.println(deserializer.deserialize(xml, Animal.class));
        System.out.println(deserializer.deserialize(xml, Car.class));

    }
}
