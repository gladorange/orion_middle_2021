package com.example.serializer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlSerializer {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlName {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlTypeName {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlIgnore {
    }

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) {
            Class<?> aClass = object.getClass();

            String className = aClass.getSimpleName();
            XmlTypeName aClassAnnotation = aClass.getAnnotation(XmlTypeName.class);

            if (aClassAnnotation != null) {
                className = aClassAnnotation.name();
            }

            builder.append("<" + className + ">\n");

            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                    continue;
                }
                String fieldName = declaredField.getName();

                XmlName annotation = declaredField.getAnnotation(XmlName.class);
                if (annotation != null) {
                    fieldName = annotation.name();
                }

                builder.append("\t<" + fieldName + ">");
                builder.append(declaredField.get(object));
                builder.append("</" + fieldName + ">\n");
            }

            builder.append("</" + className + ">");

        }
        return builder.toString();
    }

    public static Object deserialize(String xml, Class<?> className) throws InstantiationException, IllegalAccessException {
        Object object = className.newInstance();

        String mainTagName = className.getSimpleName();
        XmlTypeName classNameAnnotation = className.getAnnotation(XmlTypeName.class);

        if (classNameAnnotation != null) {
            mainTagName = classNameAnnotation.name();
        }

        Pattern r = Pattern.compile("<" + mainTagName + ">\\n\\t*(?<body>(\\s|\\S)*)\\n*<\\/" + mainTagName + ">");
        Matcher matcher = r.matcher(xml);
        if (matcher.find()) {
            String body = matcher.group("body");
            for (Field declaredField : className.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                    continue;
                }

                String tagName = declaredField.getName();
                XmlName fieldAnnotation = declaredField.getAnnotation(XmlName.class);

                if (fieldAnnotation != null) {
                    tagName = fieldAnnotation.name();
                }

                Pattern fieldPattern = Pattern.compile("<" + tagName + ">(?<body>.*)</" + tagName + ">");
                Matcher fieldMatcher = fieldPattern.matcher(body);

                if (fieldMatcher.find()) {
                    String fieldValue = fieldMatcher.group("body");
                    if (fieldValue.equals("null")) {
                        continue;
                    }
                    if (declaredField.getType() == String.class) {
                        declaredField.set(object, fieldValue);
                    }
                    if (declaredField.getType() == int.class || declaredField.getType() == Integer.class) {
                        declaredField.set(object, Integer.parseInt(fieldValue));
                    }
                    if (declaredField.getType() == Boolean.class) {
                        declaredField.set(object, Boolean.parseBoolean(fieldValue));
                    }
                }
            }

        }
        return object;
    }
}
