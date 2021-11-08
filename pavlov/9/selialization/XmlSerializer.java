package selialization;

import selialization.annotations.XmlIgnore;
import selialization.annotations.XmlName;
import selialization.annotations.XmlTypeName;

import java.lang.reflect.Field;
import java.util.Collection;

public class XmlSerializer {
    public String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("<xml>\n");

        for(Object object: objects){
            serializeObject(stringBuilder, object);
        }

        stringBuilder.append("</xml>");

        return stringBuilder.toString();
    }

    private void serializeObject(StringBuilder stringBuilder, Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        if(objectClass.isAnnotationPresent(XmlIgnore.class)){
            return;
        }
        if(objectClass.isAnnotationPresent(XmlTypeName.class)){
            String typeName = objectClass.getAnnotation(XmlTypeName.class).value();
            stringBuilder
                    .append("\t<")
                    .append(typeName)
                    .append(">\n");

            for(Field field: objectClass.getDeclaredFields()){
                serializeField(stringBuilder, field, object);
            }

            stringBuilder
                    .append("\t</")
                    .append(typeName)
                    .append(">\n");
        }
    }

    private void serializeField(StringBuilder stringBuilder, Field field, Object object) throws IllegalAccessException {
        if(field.isAnnotationPresent(XmlIgnore.class)){
            return;
        }
        if(!field.isAnnotationPresent(XmlName.class)){
            return;
        }
        Class<?> type = field.getType();
        if(!supportSerializationFieldType(type)){
            return;
        }

        XmlName annotation = field.getAnnotation(XmlName.class);
        String fieldName = annotation.value();

        stringBuilder
                .append("\t\t<")
                .append(fieldName)
                .append(">");

        field.setAccessible(true);
        stringBuilder.append(field.get(object).toString());

        stringBuilder
                .append("</")
                .append(fieldName)
                .append(">\n");

    }

    private boolean supportSerializationFieldType(Class<?> type){
        return (type.isPrimitive() || type.equals(String.class));
    }
}
