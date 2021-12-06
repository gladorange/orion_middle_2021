package task1;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class XMLSerializer {

    @Retention(RetentionPolicy.RUNTIME)
    public static @interface XmlTypeName{
        String className();
    }
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface XmlName{
        String fieldName();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public static @interface XmlIgnore{
    }


    public static String serialize(Object o) throws IllegalAccessException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        final Class<?> obClass = o.getClass();

        String objectName = obClass.getSimpleName();
        XmlTypeName mainAnnotation = obClass.getAnnotation(XmlTypeName.class);
        if(mainAnnotation != null){
            objectName = mainAnnotation.className();
        }
        stringBuilder.append("<"+objectName+">\n");

        for (Field field: obClass.getDeclaredFields()) {
            if(field.isAnnotationPresent(XmlIgnore.class)) continue;

            field.setAccessible(true);

            if( field.getType() == String.class ||
                field.getType() == Integer.class ||
                field.getType() == Boolean.class
            ){
                String fieldName = field.getName();
                XmlName annotation = field.getAnnotation(XmlName.class);
                if(annotation !=null){
                    fieldName = annotation.fieldName();
                }
                System.out.print(fieldName+"\n");
                stringBuilder.append("\t<"+fieldName+">");
                stringBuilder.append(field.get(o).toString());
                stringBuilder.append("</"+fieldName+">\n");
            }

        }
        stringBuilder.append("</"+objectName+">\n");
        //System.out.print(stringBuilder.toString());
        return stringBuilder.toString();
    }
    public static void  serialize(Collection<?> collection){
        collection.stream().forEach(el-> {
            try {
                XMLSerializer.serialize(el);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }




}
