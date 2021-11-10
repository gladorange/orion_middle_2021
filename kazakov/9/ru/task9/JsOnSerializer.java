package ru.task9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsOnSerializer implements AutoCloseable {
    @Override
    public void close() {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface JsonTypeName {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface JsonName {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface JsonIgnore {
    }

    /**
     * Сериализуем коллекцию объектов в Json формат
     * @return serialized collection of Objects in Json format
     */
    public String toJsOn(Collection<?> objects) throws IllegalArgumentException, IllegalAccessException {

        if (objects == null)
            throw new IllegalArgumentException();
        if (objects.size() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append("{");   //  begin array
        int i = 0;
        for (Object object : objects) {
            final Class<?> aClass = object.getClass();

            if (i > 0)
                sb.append(",");
            final String objName;
            JsonTypeName typeNameAnn = aClass.getAnnotation(JsonTypeName.class);
            objName = typeNameAnn != null ? typeNameAnn.value() : aClass.getSimpleName();
            sb.append("\n\t\"").append(objName).append("\": { ");   //      begin object

            for (int j = 0; j < aClass.getDeclaredFields().length; j++) {
                final Field declaredField = aClass.getDeclaredFields()[j];
                if (declaredField.isAnnotationPresent(JsonIgnore.class)) {
                    continue;
                }
                if (j > 0)
                    sb.append(", ");
                //  key:
                final JsonName annotation = declaredField.getAnnotation(JsonName.class);
                final String jsonKey = (annotation != null) ? annotation.value() : declaredField.getName();
                sb.append("\"").append(jsonKey).append("\": ");
                //  value:
                declaredField.setAccessible(true);
                final Object jsonValue = declaredField.get(object);
                if (jsonValue instanceof String) {   //  String values embrace in double quotes
                    sb.append("\"").append(jsonValue.toString()).append("\"");
                } else {  //  other values don't
                    sb.append(jsonValue.toString());
                }
            }
            sb.append(" }");   //  end object
            i++;
        }
        sb.append("\n}");   //  end array
        return sb.toString();
    }

    /**
     * Десериализуем объект из Json. Входной Json должен содержать только объект класса с нашим искомым  className
     * иначе - возвращаем null.
     *
     * @return deSerialized Object or null
     */
    public <T> T fromJsOn(String json, Class<T> className)

    throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, IllegalStateException {

        T object = className.getDeclaredConstructor().newInstance();

        JsonTypeName classNameAnnotation = className.getAnnotation(JsonTypeName.class);
        final String mainTagName = classNameAnnotation != null ? classNameAnnotation.value() : className.getSimpleName();

        Pattern p = Pattern.compile("\\{\\s*\"(.+?)\" *?: *?\\{(.*)}"); //  regex for className
        Matcher matcher = p.matcher(json);
        if (!matcher.find())
            throw new IllegalStateException();
        final String objectName = matcher.group(1);
        //  самый простейший случай: в нашем Json должен находиться только один объект с нужным нам
        //  className. Если это не так, то выходим с null:
        if (!mainTagName.equals(objectName))
            return null;

        //  ok, это наш объект - парсим key:value pairs:
        final String keysValues = matcher.group(2);
        for (Field declaredField : className.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(JsonIgnore.class)) {
                continue;
            }

            JsonName fieldAnnotation = declaredField.getAnnotation(JsonName.class);
            String tagName = (fieldAnnotation != null) ? fieldAnnotation.value() : declaredField.getName();

            //  https://coderanch.com/t/727200/java/Regex-parse-simple-fixed-format
            p = Pattern.compile("\"(.+?)\" *?: *?(\".+?\"|\\d+\\.?\\d+|true|false|null)");
            matcher = p.matcher(keysValues);
            while (matcher.find()) {
                String key = matcher.group(1);
                if (tagName.equals(key)) { //  key
                    String value = matcher.group(2);    //  value

                    final Class<?> fieldType = declaredField.getType();
                    if (fieldType == String.class) {
                        declaredField.set(object, value);
                    } else if (fieldType == int.class) {
                        declaredField.set(object, Integer.parseInt(value));
                    } else if (fieldType == boolean.class) {
                        declaredField.set(object, Boolean.parseBoolean(value));
                    } else if (fieldType == double.class) {
                        declaredField.set(object, Double.parseDouble(value));
                    }
                    break;
                }
            }
        }
        return object;
    }
}
