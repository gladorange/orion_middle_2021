package lection9.task1;
//Домашнее задание к лекции 9
//Аннотированная де\сериализация
//Салмов Евгений

import java.awt.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlName {
        String xmlName();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlIgnore {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlTypeName {
        String xmlTypeName();
    }

    enum SerializableTypes{
        PERSON(Person.class), CAR(Car.class), DOG(Dog.class);
        private final Class<?> type;
        SerializableTypes(Class<?> type){
            this.type = type;
        }
        public Class<?> getType(){ return type;}
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Object> someObjects = new ArrayList<>();
        someObjects.add(new Person("Игорь",28.0, "qwerty1"));
        someObjects.add(new Person("Анна",31.0, "asdfg1"));
        someObjects.add(new Car("Ferrari", 310.0, Color.RED));
        someObjects.add(new Car("Lamborgini", 320.0, Color.YELLOW));
        someObjects.add(new Dog("Бобик","Фокстерьер","лиса"));
        someObjects.add(new Dog("Шарик","Шарпей","Чаппи"));
        System.out.println("Сериализация:");
        String xmlString = serialize(someObjects);
        System.out.println(xmlString);
        System.out.println("\nА теперь десериализация:");
        System.out.println(deserialize(xmlString));
    }

    static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder s = new StringBuilder();
        for (Object object: objects) {
            final Class<?> aClass = object.getClass();
            s.append(makeClassString(aClass,object));
            s.append("\n");
        }
        return s.toString();
    }

    static List<Object> deserialize(String xmlString) throws IllegalAccessException, InstantiationException {
        List<Object> objects = new ArrayList<>();
        for (SerializableTypes type: SerializableTypes.values()) {
            final Class<?> aClass = type.getType();
            String s = makeClassString(aClass,null);
            Pattern regex = Pattern.compile(s);
            Matcher m = regex.matcher(xmlString);
            while (m.find()) {
                objects.add(getObjectFromString(aClass, m.group()));
            }
        }
        return objects;
    }

    private static Object getObjectFromString(Class<?> aClass, String detectedString) throws InstantiationException, IllegalAccessException {
        Object object = aClass.newInstance();
        for (Field declaredField : aClass.getDeclaredFields()) {
            StringBuilder s = new StringBuilder();
            if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String name = declaredField.getName();
            final XmlName annotation = declaredField.getAnnotation(XmlName.class);
            if (annotation != null) {
                name = annotation.xmlName();
            }
            String openingTag = "<" + name + ">";
            String closingTag = "</" + name + ">";
            Pattern regex = Pattern.compile(openingTag + ".+" +closingTag);
            Matcher m = regex.matcher(detectedString);
            if (m.find()) {
                String ss = m.group();
                ss = ss.replace(openingTag, "");
                ss = ss.replace(closingTag,"");
                if (declaredField.getType() == String.class) {
                    declaredField.setAccessible(true);
                    declaredField.set(object,ss);
                } else if (declaredField.getType() == Boolean.class) {
                    declaredField.setAccessible(true);
                    declaredField.set(object,ss);
                } else if (declaredField.getType() == Double.class) {
                    declaredField.setAccessible(true);
                    declaredField.set(object,Double.parseDouble(ss));
                }
            }
        }
        return object;
    }

    private static String makeClassString(Class<?> aClass, Object object) throws IllegalAccessException {
        StringBuilder s = new StringBuilder();
        String typeName = aClass.getSimpleName();
        if (aClass.isAnnotationPresent(XmlTypeName.class)) {
            final XmlTypeName annotation = aClass.getAnnotation(XmlTypeName.class);
            if (annotation != null) {
                typeName = annotation.xmlTypeName();
            }
        }
        s.append("<").append(typeName).append(">\n");
        for (Field declaredField : aClass.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String name = declaredField.getName();
            final XmlName annotation = declaredField.getAnnotation(XmlName.class);
            if (annotation != null) {
                name = annotation.xmlName();
            }
            s.append("\t<").append(name).append(">");
            if(object != null){
                declaredField.setAccessible(true);
                s.append(declaredField.get(object).toString());
            }else{
                s.append(".+");
            }
            s.append("</").append(name).append(">\n");
        }
        s.append("</").append(typeName).append(">");
        return s.toString();
    }

}
