package task9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Person vasya = new Person("Vasya", 12.0, "qwerty");
        Person vania = new Person("Vania", 9.0, "asdf");
        List<Person> personList = new ArrayList<>();
        personList.add(vasya);
        personList.add(vania);
        String str = serialize(personList);
        System.out.println(str);
        new Main().deserialize(str, Person.class);

    }
    public static String serialize(Collection<?> objects) throws IllegalAccessException {

        StringBuilder sb = new StringBuilder();
        for(Object object : objects) {
            final Class<?> aClass = object.getClass();
            sb.append("<" + aClass.getSimpleName() + ">\n");
            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                    continue;
                }

                String name = declaredField.getName();
                final XmlName annotation = declaredField.getAnnotation(XmlName.class);

                if (annotation != null) {
                    name = annotation.name();
                }
                sb.append("\t<" + name + ">");
                declaredField.setAccessible(true);
                sb.append(declaredField.get(object).toString());
                sb.append("</" + name + ">\n");

            }
            sb.append("</" + aClass.getSimpleName() + ">\n");
        }
        return sb.toString();
    }

    public <T> T deserialize(String str, Class<T> type){
          String classTag = type.getSimpleName();
          List<String> tags = new ArrayList<>();
        for(Field declaredField : type.getDeclaredFields()){
            Annotation[] annotations = declaredField.getAnnotations();
            for(Annotation annotation : annotations) {
                if(annotation.annotationType().getName().contains("XmlName")){
                    tags.add(declaredField.getAnnotation(XmlName.class).name());
                }
            }
        }

        String[] split = str.split("<\\/" + classTag + ">");

        for(String splitedStr : split) {
            if(!splitedStr.isEmpty()) {
                Map<String, String> fields = new HashMap<>();
                for (String tag : tags) {
                    String result = tagMatcher(splitedStr, tag);
                    if(result != null) {
                        fields.put(tag, result);
                    }

                }
                System.out.println(fields);
                if(fields.get("name") != null) {
                    Container<Person> instance = new Container<>(() ->
                            new Person(fields.get("name"), Double.parseDouble(fields.get("age")), null));
                    if (instance.createContents() != null) {
                        System.out.println(instance.createContents());
                    }
                }
            }
        }
        return null;
    }

    public static String tagMatcher(String str, String tag) {
        Pattern p = Pattern.compile("<"+tag+">(.+?)<\\/"+tag+">");
        Matcher m = p.matcher(str);
        String result = null;
        while(m.find()){
            System.out.println(m.group(1));
             result =  m.group(1);

        }
        return result;
    }

    class Container<E> {
        private Supplier<E> supplier;

        Container(Supplier<E> supplier) {
            this.supplier = supplier;
        }

        E createContents() {
            return supplier.get();
        }
    }

}
