package selialization;

import corteges.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import selialization.annotations.XmlName;
import selialization.annotations.XmlTypeName;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class XmlDeserializer {

    public Collection<?> deserialize(String xml, Class<?> outputClass) throws XmlDeserializationException {
        try {
            Collection<Object> result = new HashSet<>();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml)));

            String typeName = getTypeName(outputClass);
            NodeList nodes = doc.getElementsByTagName(typeName);

            for(int i=0; i<nodes.getLength(); i++){

                Node parentNode = nodes.item(i);

                Object instance = getInstance(outputClass);

                NodeList childNodes = parentNode.getChildNodes();
                for(int j=0; j<childNodes.getLength(); j++){
                    Node childNode = childNodes.item(j);

                    Optional<Field> fieldOptional = getField(childNode.getNodeName(), outputClass);
                    if(fieldOptional.isPresent()){
                        Field field = fieldOptional.get();
                        setValueToField(field, instance, childNode);
                    }
                }
                result.add(instance);
            }
            return result;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new XmlDeserializationException("XML parsing Exception");
        }
    }

    private String getTypeName(Class<?> outputClass) throws XmlDeserializationException {
        XmlTypeName annotation = outputClass.getAnnotation(XmlTypeName.class);
        if(annotation == null){
            throw new XmlDeserializationException("XmlTypeName for "+outputClass.getName()+" undefined.");
        }
        return annotation.value();
    }

    private Optional<Field> getField(String nodeName, Class<?> outputClass){
        Field[] fields = outputClass.getDeclaredFields();
        for(Field field: fields){
            XmlName xmlName = field.getAnnotation(XmlName.class);
            if(xmlName != null && nodeName.equals(xmlName.value())){
                return Optional.of(field);
            }
        }
        return Optional.empty();
    }

    private void setValueToField(Field field, Object object, Node nodeValue) throws XmlDeserializationException {
        try{
            String value = nodeValue.getTextContent();
            Class<?> type = field.getType();
            field.setAccessible(true);
            if(type.equals(String.class)){
                field.set(object, value);
            } else if(type.equals(boolean.class)){
                field.setBoolean(object, Boolean.parseBoolean(value));
            } else if(type.equals(char.class)){
                field.setChar(object, value.charAt(0));
            } else if(type.equals(byte.class)){
                field.setByte(object, Byte.parseByte(value));
            } else if(type.equals(short.class)){
                field.setShort(object, Short.parseShort(value));
            } else if(type.equals(int.class)){
                field.setInt(object, Integer.parseInt(value));
            } else if(type.equals(long.class)){
                field.setLong(object, Long.parseLong(value));
            } else if(type.equals(float.class)){
                field.setFloat(object, Float.parseFloat(value));
            } else if(type.equals(double.class)){
                field.setDouble(object, Double.parseDouble(value));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new XmlDeserializationException("Wrong value for "+field.getName()+": "+nodeValue.getNodeValue());
        }
    }

    private Object getInstance(Class<?> outputClass) throws XmlDeserializationException {
        Constructor<?> defaultConstructor = getDefaultConstructor(outputClass);
        if(defaultConstructor == null){
            throw new XmlDeserializationException(outputClass.getName()+" don't have default constructor");
        }
        try {
            return defaultConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new XmlDeserializationException("Cannot create instance for "+outputClass.getName());
        }
    }

    private Constructor<?> getDefaultConstructor(Class<?> outputClass){
        final Constructor<?>[] declaredConstructors = outputClass.getDeclaredConstructors();

        for(Constructor<?> constructor: declaredConstructors){
            constructor.setAccessible(true);
            if(constructor.getParameterCount()==0){
                return constructor;
            }
        }
        return null;
    }

    public static class XmlDeserializationException extends Exception {
        public XmlDeserializationException(String message){
            super(message);
        }
    }
}
