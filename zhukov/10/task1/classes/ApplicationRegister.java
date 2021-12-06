package task1.classes;

import java.util.HashMap;
import java.util.Map;

public class ApplicationRegister {

    private static ApplicationRegister instance;

    private static Map<String,String> applicationData = new HashMap<>();

    private ApplicationRegister(){}

    public static ApplicationRegister getInstance(){
        if(instance == null){
            instance = new ApplicationRegister();
        }
        return instance;
    }

    public void set( String key, String value) {
        this.applicationData.put(key, value);
    }
    public String get(String key){
        return this.applicationData.get(key);
    }
}
