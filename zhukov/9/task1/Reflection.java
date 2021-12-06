package task1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, ParserConfigurationException, SAXException, NoSuchMethodException {

        Person somePerson = new Person();
        somePerson.setName("Pavel");
        somePerson.setAge(19);

        String serializedObject = XMLSerializer.serialize(somePerson);
        System.out.print(serializedObject);

        XMLDeserializer.deserialize(serializedObject, Person.class);
/*

        final Class<?> personClass = Person.class;
        //final Class<?> personClass = Class.forName("task1.Person");

        final Constructor<Person>[] constructors = (Constructor<Person>[]) personClass.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        final Person person  =  constructors[0].newInstance("Pasaul",10);
        System.out.print( person.getName() + " \n" );

        final Field[] fields = personClass.getDeclaredFields();
        System.out.printf("%s \n", Arrays.toString(fields) );

        final Method[] methods = personClass.getDeclaredMethods();
        System.out.printf("%s \n",Arrays.toString(methods));

        for (Field field:fields) {
            if(field.getType() == String.class){
                field.setAccessible(true);
                System.out.printf("Field %s type - %s \n",field.getName(), field.getType());
                field.set(person,"Vasya");
                //System.out.print(field.getType()+"\n");

            }
        }

        for (Method method:methods) {

            if(method.getParameterTypes().length > 0  && method.getParameterTypes()[0] == String.class){
                method.invoke(person,"PASHA");
                System.out.printf("Method %s\n",method.getName() );
            }
        }*/
    }

    public static void  serialize(){

    }


}
