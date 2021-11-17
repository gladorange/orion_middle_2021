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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class XMLDeserializer {

    public static  <T extends Object> T deserialize(String serialized, Class  incomingClass) throws IllegalAccessException, ParserConfigurationException, IOException, SAXException, NoSuchMethodException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        final Constructor constructor =   incomingClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        final T  newInstance = (T) constructor.newInstance(null);

        String objectName = incomingClass.getSimpleName();

        XMLSerializer.XmlTypeName mainAnnotation = (XMLSerializer.XmlTypeName) incomingClass.getAnnotation(XMLSerializer.XmlTypeName.class);
        if(mainAnnotation != null){
            objectName = mainAnnotation.className();
        }
        if(mainAnnotation != null){
            objectName = mainAnnotation.className();
        }

        Map<String, String> map = getMapFromXML(serialized, objectName);

        for (Field field: incomingClass.getDeclaredFields()) {
            if(field.isAnnotationPresent(XMLSerializer.XmlIgnore.class)) continue;

            field.setAccessible(true);

            if( field.getType() == String.class ||
                    field.getType() == Integer.class ||
                    field.getType() == Boolean.class
            ){
                String fieldName = field.getName();
                XMLSerializer.XmlName annotation = field.getAnnotation(XMLSerializer.XmlName.class);
                if(annotation !=null){
                    fieldName = annotation.fieldName();
                }

                String val = map.get(fieldName).toString();
                addPropValue(newInstance, field, val);
            }

        }
        System.out.printf("Object %s \n",newInstance);
        return newInstance;
    }

    private static <T extends Object> void addPropValue(T newInstance, Field field, String val) throws IllegalAccessException {
        field.setAccessible(true);

        if(field.getType() == String.class){
            field.set(newInstance, val);
        }
        if(field.getType() == Integer.class){
            field.set(newInstance, Integer.parseInt(val));
        }
        if(field.getType() == Boolean.class){
            field.set(newInstance, Boolean.parseBoolean(val));
        }
    }

    @NotNull
    private static Map<String, String> getMapFromXML(String serialized, String objectName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory docFactoryObject = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = docFactoryObject.newDocumentBuilder();
        Document doc = documentBuilder.parse(new InputSource(new StringReader(serialized)));

        NodeList elements = doc.getElementsByTagName(objectName);

        Map<String ,String > map  = new HashMap<>();
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);

            if (element.getNodeType() != Node.TEXT_NODE) {
                NodeList elementProps = element.getChildNodes();
                for(int j = 0; j < elementProps.getLength(); j++) {
                    Node elementProp = elementProps.item(j);

                    if (elementProp.getNodeType() != Node.TEXT_NODE) {
                        map.put(
                                elementProp.getNodeName(),
                                elementProp.getChildNodes().item(0).getTextContent()
                                );
                    }
                }

            }
        }
        return map;
    }
}
